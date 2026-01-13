package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;
import Tg.ipnet.FirstSpring.service1.ProgrammeService;

@RestController("programmeControllerV2")
@RequestMapping("/api/programmes")
@CrossOrigin("*")
public class ProgrammeController {

    private final ProgrammeService programmeService;

    public ProgrammeController(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }

    @PostMapping("/save")
    public ProgrammeDTO create(@RequestBody ProgrammeDTO dto) {
        return programmeService.save(dto);
    }

    @PutMapping("/update/{id}")
    public ProgrammeDTO update(@PathVariable Long id, @RequestBody ProgrammeDTO dto) {
        return programmeService.update(id, dto);
    }

    @GetMapping("one/{id}")
    public ProgrammeDTO getById(@PathVariable Long id) {
        return programmeService.findById(id);
    }

    @GetMapping("/list")
    public List<ProgrammeDTO> getAll() {
        return programmeService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        programmeService.delete(id);
    }
}
