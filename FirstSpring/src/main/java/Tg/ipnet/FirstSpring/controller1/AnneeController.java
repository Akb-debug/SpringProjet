package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.AnneeDTO;
import Tg.ipnet.FirstSpring.service1.AnneeService;

@RestController("anneeControllerV2")
@RequestMapping("/api/v2/annees/")
public class AnneeController {

    private final AnneeService service;

    public AnneeController(AnneeService service) {
        this.service = service;
    }

    @PostMapping("save")
    public AnneeDTO create(@RequestBody AnneeDTO dto) {
        return service.create(dto);
    }

    @PutMapping("update/{id}")
    public AnneeDTO update(@RequestBody AnneeDTO dto, @PathVariable Long id) {
        return service.update(dto, id);
    }

    @GetMapping("liste")
    public List<AnneeDTO> list() {
        return service.list();
    }

    @GetMapping("oneAnnee/{id}")
    public AnneeDTO get(@PathVariable Long id) {
        return service.getAnnee(id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
