package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.entity.Note;
import Tg.ipnet.FirstSpring.service.NoteService;

@RestController
@RequestMapping("api/v1/note")
@CrossOrigin("*")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    public Note create(@RequestBody Note n){
        return noteService.create(n);
    }

    @GetMapping("/all")
    public List<Note> list(){
        return noteService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        noteService.delete(id);
    }

    @GetMapping("/one/{id}")
    public Note getNote(@PathVariable Long id){
        return noteService.getNote(id);
    }

    @PutMapping("/update/{id}")
    public Note update(@RequestBody Note n, @PathVariable Long id){
        return noteService.update(n, id);
    }
}
