package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.entity.Programme;
import Tg.ipnet.FirstSpring.service.ProgrammeService;

@RestController
@RequestMapping("api/v1/programme")
@CrossOrigin("*")
public class ProgrammeController {

    private final ProgrammeService programmeService;

    public ProgrammeController(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }

    @PostMapping("/save")
    public Programme create(@RequestBody Programme p){
        return programmeService.create(p);
    }

    @GetMapping("/all")
    public List<Programme> list(){
        return programmeService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        programmeService.delete(id);
    }

    @GetMapping("/one/{id}")
    public Programme getProgramme(@PathVariable Long id){
        return programmeService.getProgramme(id);
    }

    @PutMapping("/update/{id}")
    public Programme update(@RequestBody Programme p, @PathVariable Long id){
        return programmeService.update(p, id);
    }
}
