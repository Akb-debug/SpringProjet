package Tg.ipnet.FirstSpring.service1.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.FiliereDTO;
import Tg.ipnet.FirstSpring.entity.Filiere;
import Tg.ipnet.FirstSpring.mapper.FiliereMapper;
import Tg.ipnet.FirstSpring.repository.FiliereRepository;
import Tg.ipnet.FirstSpring.service1.FiliereService;

@Service
public class FiliereServiceImpl implements FiliereService {

    private final FiliereRepository repository;
    private final FiliereMapper mapper;

    public FiliereServiceImpl(FiliereRepository repository, FiliereMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FiliereDTO create(FiliereDTO dto) {

        if (repository.existsByNom(dto.getNom())) {
            throw new RuntimeException("Une filière avec ce nom existe déjà");
        }

        Filiere filiere = mapper.toEntity(dto);
        Filiere saved = repository.save(filiere);

        return mapper.toDto(saved);
    }

    @Override
    public FiliereDTO update(FiliereDTO dto, Long id) {

        Filiere filiere = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filière introuvable"));

        filiere.setNom(dto.getNom());
        filiere.setDescription(dto.getDescription());

        Filiere updated = repository.save(filiere);

        return mapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public FiliereDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Filière introuvable"));
    }

    @Override
    public List<FiliereDTO> list() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
