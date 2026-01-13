package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.TypeUEDTO;
import Tg.ipnet.FirstSpring.service1.TypeUEService;

@RestController("typeUEControllerV2")
@RequestMapping("/api/v2/type-ues")
public class TypeUEController {

    private final TypeUEService service;

    public TypeUEController(TypeUEService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public TypeUEDTO create(@RequestBody TypeUEDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public TypeUEDTO update(@PathVariable Long id, @RequestBody TypeUEDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/list")
    public List<TypeUEDTO> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public TypeUEDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
