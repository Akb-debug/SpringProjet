package Tg.ipnet.FirstSpring.service1.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.UeDTO;
import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.entity.TypeUE;
import Tg.ipnet.FirstSpring.entity.Ue;
import Tg.ipnet.FirstSpring.mapper.UeMapper;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;
import Tg.ipnet.FirstSpring.repository.TypeUERepository;
import Tg.ipnet.FirstSpring.repository.UERepository;
import Tg.ipnet.FirstSpring.service1.UeService;

@Service
public class UeServiceImpl implements UeService {

    private final UERepository ueRepository;
    private final TypeUERepository typeUERepository;
    private final ParcoursRepository parcoursRepository;
    private final UeMapper mapper;

    public UeServiceImpl(
            UERepository ueRepository,
            TypeUERepository typeUERepository,
            ParcoursRepository parcoursRepository,
            UeMapper mapper
    ) {
        this.ueRepository = ueRepository;
        this.typeUERepository = typeUERepository;
        this.parcoursRepository = parcoursRepository;
        this.mapper = mapper;
    }

    @Override
    public UeDTO create(UeDTO dto) {

        Ue ue = mapper.toEntity(dto);

        TypeUE typeUE = typeUERepository.findById(dto.getTypeUEId())
                .orElseThrow(() -> new RuntimeException("Type UE introuvable"));

        Parcours parcours = parcoursRepository.findById(dto.getParcoursId())
                .orElseThrow(() -> new RuntimeException("Parcours introuvable"));

        ue.setTypeUE(typeUE);
        ue.setParcours(parcours);

        return mapper.toDto(ueRepository.save(ue));
    }

    @Override
    public UeDTO update(Long id, UeDTO dto) {

        Ue ue = ueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UE introuvable"));

        ue.setCodeUE(dto.getCodeUE());
        ue.setIntituleUE(dto.getIntituleUE());
        ue.setCredit(dto.getCredit());

        if (dto.getTypeUEId() != null) {
            ue.setTypeUE(
                typeUERepository.findById(dto.getTypeUEId())
                    .orElseThrow(() -> new RuntimeException("Type UE introuvable"))
            );
        }

        if (dto.getParcoursId() != null) {
            ue.setParcours(
                parcoursRepository.findById(dto.getParcoursId())
                    .orElseThrow(() -> new RuntimeException("Parcours introuvable"))
            );
        }

        return mapper.toDto(ueRepository.save(ue));
    }

    @Override
    public UeDTO getById(Long id) {
        return mapper.toDto(
            ueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UE introuvable"))
        );
    }

    @Override
    public List<UeDTO> list() {
        return ueRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        ueRepository.deleteById(id);
    }
}
