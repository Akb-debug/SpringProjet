package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.entity.TypeUE;
import Tg.ipnet.FirstSpring.service.TypeUEService;

@RestController
@RequestMapping("api/v1/typeue")
@CrossOrigin("*")
public class TypeUEController {

    private final TypeUEService typeUEService;

    public TypeUEController(TypeUEService typeUEService) {
        this.typeUEService = typeUEService;
    }

    @PostMapping("/save")
    public TypeUE create(@RequestBody TypeUE t){
        return typeUEService.create(t);
    }

    @GetMapping("/all")
    public List<TypeUE> list(){
        return typeUEService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        typeUEService.delete(id);
    }

    @GetMapping("/one/{id}")
    public TypeUE getTypeUE(@PathVariable Long id){
        return typeUEService.getTypeUE(id);
    }

    @PutMapping("/update/{id}")
    public TypeUE update(@RequestBody TypeUE t, @PathVariable Long id){
        return typeUEService.update(t, id);
    }
}
