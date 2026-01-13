package Tg.ipnet.FirstSpring.service1.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.TypeUEDTO;
import Tg.ipnet.FirstSpring.entity.TypeUE;
import Tg.ipnet.FirstSpring.mapper.TypeUEMapper;
import Tg.ipnet.FirstSpring.repository.TypeUERepository;
import Tg.ipnet.FirstSpring.service1.TypeUEService;

@Service
public class TypeUEServiceImpl implements TypeUEService {

    private final TypeUERepository repository;
    private final TypeUEMapper mapper;

    public TypeUEServiceImpl(TypeUERepository repository, TypeUEMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TypeUEDTO create(TypeUEDTO dto) {
        TypeUE entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public TypeUEDTO update(Long id, TypeUEDTO dto) {
        TypeUE typeUE = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type UE introuvable"));

        typeUE.setLibelle(dto.getLibelle());
        typeUE.setDescription(dto.getDescription());

        return mapper.toDto(repository.save(typeUE));
    }

    @Override
    public TypeUEDTO getById(Long id) {
        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Type UE introuvable"))
        );
    }

    @Override
    public List<TypeUEDTO> list() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
