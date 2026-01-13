package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.InscriptionDTO;
import Tg.ipnet.FirstSpring.service1.InscriptionService;

@RestController("inscriptionControllerV2")
@RequestMapping("/api/v2/inscriptions")
public class InscriptionController {

    private final InscriptionService service;

    public InscriptionController(InscriptionService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public InscriptionDTO create(@RequestBody InscriptionDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public InscriptionDTO update(@RequestBody InscriptionDTO dto, @PathVariable Long id) {
        return service.update(dto, id);
    }

    @GetMapping("/list")
    public List<InscriptionDTO> list() {
        return service.list();
    }

    @GetMapping("/one/{id}")
    public InscriptionDTO get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
