package Tg.ipnet.FirstSpring.service1.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.NoteDTO;
import Tg.ipnet.FirstSpring.entity.Inscription;
import Tg.ipnet.FirstSpring.entity.Note;
import Tg.ipnet.FirstSpring.entity.Ue;
import Tg.ipnet.FirstSpring.mapper.NoteMapper;
import Tg.ipnet.FirstSpring.repository.InscriptionRepository;
import Tg.ipnet.FirstSpring.repository.NoteRepository;
import Tg.ipnet.FirstSpring.repository.UERepository;
import Tg.ipnet.FirstSpring.service1.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepo;
    private final UERepository ueRepo;
    private final InscriptionRepository inscriptionRepo;
    private final NoteMapper mapper;

    public NoteServiceImpl(NoteRepository noteRepo,
                           UERepository ueRepo,
                           InscriptionRepository inscriptionRepo,
                           NoteMapper mapper) {
        this.noteRepo = noteRepo;
        this.ueRepo = ueRepo;
        this.inscriptionRepo = inscriptionRepo;
        this.mapper = mapper;
    }

    @Override
    public NoteDTO create(NoteDTO dto) {
        Note note = mapper.toEntity(dto);

        Ue ue = ueRepo.findById(dto.getUeId())
                .orElseThrow(() -> new RuntimeException("UE introuvable"));

        Inscription inscription = inscriptionRepo.findById(dto.getInscriptionId())
                .orElseThrow(() -> new RuntimeException("Inscription introuvable"));

        note.setUe(ue);
        note.setInscription(inscription);

        return mapper.toDto(noteRepo.save(note));
    }

    @Override
    public NoteDTO update(Long id, NoteDTO dto) {
        Note note = noteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note introuvable"));

        note.setNoteObtenue(dto.getNoteObtenue());
        note.setDateObtention(dto.getDateObtention());
        note.setTypeEvaluation(dto.getTypeEvaluation());

        if (dto.getUeId() != null) {
            note.setUe(
                ueRepo.findById(dto.getUeId())
                    .orElseThrow(() -> new RuntimeException("UE introuvable"))
            );
        }

        if (dto.getInscriptionId() != null) {
            note.setInscription(
                inscriptionRepo.findById(dto.getInscriptionId())
                    .orElseThrow(() -> new RuntimeException("Inscription introuvable"))
            );
        }

        return mapper.toDto(noteRepo.save(note));
    }

    @Override
    public NoteDTO getById(Long id) {
        return mapper.toDto(
            noteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note introuvable"))
        );
    }

    @Override
    public List<NoteDTO> getAll() {
        return noteRepo.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        noteRepo.deleteById(id);
    }
}
