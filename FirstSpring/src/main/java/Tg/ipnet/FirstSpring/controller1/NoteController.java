package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.NoteDTO;
import Tg.ipnet.FirstSpring.service1.NoteService;

@RestController("notesControllerV2")
@RequestMapping("/api/v2/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public NoteDTO create(@RequestBody NoteDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public NoteDTO update(@PathVariable Long id, @RequestBody NoteDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/one/{id}")
    public NoteDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/list")
    public List<NoteDTO> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
