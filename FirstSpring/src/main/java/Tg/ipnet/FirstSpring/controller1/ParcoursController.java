package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.ParcoursDTO;
import Tg.ipnet.FirstSpring.service1.ParcoursService;

@RestController("parcoursControllerV2")
@RequestMapping("/api/v2/parcours")
public class ParcoursController {

    private final ParcoursService service;

    public ParcoursController(ParcoursService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ParcoursDTO create(@RequestBody ParcoursDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public ParcoursDTO update(@RequestBody ParcoursDTO dto, @PathVariable Long id) {
        return service.update(dto, id);
    }

    @GetMapping("/liste")
    public List<ParcoursDTO> list() {
        return service.list();
    }

    @GetMapping("/one/{id}")
    public ParcoursDTO get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
