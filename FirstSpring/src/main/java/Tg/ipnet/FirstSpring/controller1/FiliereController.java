package Tg.ipnet.FirstSpring.controller1;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.FiliereDTO;
import Tg.ipnet.FirstSpring.service1.FiliereService;

@RestController("filiereControllerV2")
@RequestMapping("/api/v2/filieres")
public class FiliereController {

    private final FiliereService service;

    public FiliereController(FiliereService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public FiliereDTO create(@RequestBody FiliereDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public FiliereDTO update(@RequestBody FiliereDTO dto, @PathVariable Long id) {
        return service.update(dto, id);
    }

    @GetMapping("/list")
    public List<FiliereDTO> list() {
        return service.list();
    }

    @GetMapping("one/{id}")
    public FiliereDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
