package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Tg.ipnet.FirstSpring.entity.Note;
import Tg.ipnet.FirstSpring.repository.NoteRepository;

@Service
@Transactional
public class NoteServiceImp implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImp(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note create(Note n) {
        return noteRepository.save(n);
    }

    @Override
    public Note update(Note n, Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note non trouvée"));
        note.setNoteObtenue(n.getNoteObtenue());
        note.setDateObtention(n.getDateObtention());
        note.setTypeEvaluation(n.getTypeEvaluation());
        note.setUe(n.getUe());
        note.setInscription(n.getInscription());
        return noteRepository.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> list() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNote(Long id) {
        return noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note non trouvée"));
    }
}
