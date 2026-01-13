package Tg.ipnet.FirstSpring.service1.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;
import Tg.ipnet.FirstSpring.entity.Annee;
import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.entity.Programme;
import Tg.ipnet.FirstSpring.entity.Ue;
import Tg.ipnet.FirstSpring.mapper.ProgrammeMapper;
import Tg.ipnet.FirstSpring.repository.AnneeRepository;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;
import Tg.ipnet.FirstSpring.repository.ProgrammeRepository;
import Tg.ipnet.FirstSpring.repository.UERepository;
import Tg.ipnet.FirstSpring.service1.ProgrammeService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {

    private final ProgrammeRepository programmeRepository;
    private final ParcoursRepository parcoursRepository;
    private final AnneeRepository anneeRepository;
    private final UERepository ueRepository;
    private final ProgrammeMapper programmeMapper;

    public ProgrammeServiceImpl(
            ProgrammeRepository programmeRepository,
            ParcoursRepository parcoursRepository,
            AnneeRepository anneeRepository,
            UERepository ueRepository,
            ProgrammeMapper programmeMapper) {

        this.programmeRepository = programmeRepository;
        this.parcoursRepository = parcoursRepository;
        this.anneeRepository = anneeRepository;
        this.ueRepository = ueRepository;
        this.programmeMapper = programmeMapper;
    }

    @Override
    public ProgrammeDTO save(ProgrammeDTO dto) {

        Programme programme = programmeMapper.toEntity(dto);

        Parcours parcours = parcoursRepository.findById(dto.getParcoursId())
                .orElseThrow(() -> new EntityNotFoundException("Parcours introuvable"));

        Annee annee = anneeRepository.findById(dto.getAnneeId())
                .orElseThrow(() -> new EntityNotFoundException("Année introuvable"));

        Ue ue = ueRepository.findById(dto.getUeId())
                .orElseThrow(() -> new EntityNotFoundException("UE introuvable"));

        programme.setParcours(parcours);
        programme.setAnnee(annee);
        programme.setUe(ue);

        return programmeMapper.toDto(programmeRepository.save(programme));
    }

    @Override
    public ProgrammeDTO update(Long id, ProgrammeDTO dto) {

        Programme programme = programmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Programme introuvable"));

        programme.setLibelle(dto.getLibelle());
        programme.setDescription(dto.getDescription());

        if (dto.getParcoursId() != null) {
            programme.setParcours(
                parcoursRepository.findById(dto.getParcoursId())
                    .orElseThrow(() -> new EntityNotFoundException("Parcours introuvable"))
            );
        }

        if (dto.getAnneeId() != null) {
            programme.setAnnee(
                anneeRepository.findById(dto.getAnneeId())
                    .orElseThrow(() -> new EntityNotFoundException("Année introuvable"))
            );
        }

        if (dto.getUeId() != null) {
            programme.setUe(
                ueRepository.findById(dto.getUeId())
                    .orElseThrow(() -> new EntityNotFoundException("UE introuvable"))
            );
        }

        return programmeMapper.toDto(programmeRepository.save(programme));
    }

    @Override
    public ProgrammeDTO findById(Long id) {
        return programmeMapper.toDto(
            programmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Programme introuvable"))
        );
    }

    @Override
    public List<ProgrammeDTO> findAll() {
        return programmeRepository.findAll()
                .stream()
                .map(programmeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        programmeRepository.deleteById(id);
    }
}
