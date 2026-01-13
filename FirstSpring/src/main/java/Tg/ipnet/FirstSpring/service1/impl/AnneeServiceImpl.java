package Tg.ipnet.FirstSpring.service1.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.AnneeDTO;
import Tg.ipnet.FirstSpring.entity.Annee;
import Tg.ipnet.FirstSpring.mapper.AnneeMapper;
import Tg.ipnet.FirstSpring.repository.AnneeRepository;
import Tg.ipnet.FirstSpring.service1.AnneeService;

@Service
public class AnneeServiceImpl implements AnneeService {

    private final AnneeRepository repository;
    private final AnneeMapper mapper;

    public AnneeServiceImpl(AnneeRepository repository, AnneeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AnneeDTO create(AnneeDTO dto) {
        if (Boolean.TRUE.equals(dto.getEstActive())
                && repository.existsByEstActiveTrue()) {
            throw new RuntimeException("Une année active existe déjà");
        }

        Annee entity = mapper.toEntity(dto);
        Annee saveAnnee = repository.save(entity);
        
        return mapper.toDto(saveAnnee);
    }

    @Override
    public AnneeDTO update(AnneeDTO dto, Long id) {

        Annee existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Année introuvable"));

        existing.setDateDebut(dto.getDateDebut());
        existing.setDateFin(dto.getDateFin());
        existing.setEstActive(dto.getEstActive());

        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Année introuvable");
        }
        repository.deleteById(id);
    }

    @Override
    public List<AnneeDTO> list() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    
    public List<AnneeDTO> list1(){
    	List<Annee> listAnnee = repository.findAll();
    	List<AnneeDTO> listAnneeDto = new ArrayList<>();
    	for(Annee annee : listAnnee) {
    		listAnneeDto.add(mapper.toDto(annee));
    	}
		return listAnneeDto;
    	
    }

    @Override
    public AnneeDTO getAnnee(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Année introuvable"));
    }
}
