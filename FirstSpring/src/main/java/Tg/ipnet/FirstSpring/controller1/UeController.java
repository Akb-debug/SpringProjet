package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.UeDTO;
import Tg.ipnet.FirstSpring.service1.UeService;

@RestController("ueControllerV2")
@RequestMapping("/api/v2/ues")
public class UeController {

    private final UeService service;

    public UeController(UeService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public UeDTO create(@RequestBody UeDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public UeDTO update(@PathVariable Long id, @RequestBody UeDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/list")
    public List<UeDTO> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public UeDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
