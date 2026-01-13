package Tg.ipnet.FirstSpring.service1.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.ParcoursDTO;
import Tg.ipnet.FirstSpring.entity.Filiere;
import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.mapper.ParcoursMapper;
import Tg.ipnet.FirstSpring.repository.FiliereRepository;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;
import Tg.ipnet.FirstSpring.service1.ParcoursService;

@Service
public class ParcoursServiceImpl implements ParcoursService {

    private final ParcoursRepository repository;
    private final FiliereRepository filiereRep;
    private final ParcoursMapper mapper;

    public ParcoursServiceImpl(ParcoursRepository repository, FiliereRepository filiereRep, ParcoursMapper mapper) {
        this.repository = repository;
        this.filiereRep = filiereRep;
        this.mapper = mapper;
    }

    @Override
    public ParcoursDTO create(ParcoursDTO dto) {
        Parcours p = mapper.toEntity(dto);
        Filiere f = filiereRep.findById(dto.getFiliereId())
                .orElseThrow(() -> new RuntimeException("Filière introuvable"));
        p.setFiliere(f);
        return mapper.toDto(repository.save(p));
    }

    @Override
    public ParcoursDTO update(ParcoursDTO dto, Long id) {
        Parcours p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcours introuvable"));
        p.setNom(dto.getNom());
        p.setNbrSemestre(dto.getNbrSemestre());
        Filiere f = filiereRep.findById(dto.getFiliereId())
                .orElseThrow(() -> new RuntimeException("Filière introuvable"));
        p.setFiliere(f);
        return mapper.toDto(repository.save(p));
    }

    @Override
    public List<ParcoursDTO> list() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParcoursDTO get(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcours introuvable")));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
