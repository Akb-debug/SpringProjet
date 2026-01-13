package Tg.ipnet.FirstSpring.service1;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.NoteDTO;

public interface NoteService {

    NoteDTO create(NoteDTO dto);
    NoteDTO update(Long id, NoteDTO dto);
    NoteDTO getById(Long id);
    List<NoteDTO> getAll();
    void delete(Long id);
}
