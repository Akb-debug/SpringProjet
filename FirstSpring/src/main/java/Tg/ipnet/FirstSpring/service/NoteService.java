package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.Note;

public interface NoteService {

    public Note create(Note n);

    public Note update(Note n, Long id);

    public void delete(Long id);

    public List<Note> list();

    public Note getNote(Long id);
}
