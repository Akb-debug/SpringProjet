package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.service.ParcoursService;

@RestController
@RequestMapping("api/v1/parcours")
@CrossOrigin("*")
public class ParcoursController {

    private final ParcoursService parcoursService;

    public ParcoursController(ParcoursService parcoursService) {
        this.parcoursService = parcoursService;
    }

    @PostMapping("/save")
    public Parcours create(@RequestBody Parcours p){
        return parcoursService.create(p);
    }

    @GetMapping("/all")
    public List<Parcours> list(){
        return parcoursService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        parcoursService.delete(id);
    }

    @GetMapping("/one/{id}")
    public Parcours getParcours(@PathVariable Long id){
        return parcoursService.getParcours(id);
    }

    @PutMapping("/update/{id}")
    public Parcours update(@RequestBody Parcours p, @PathVariable Long id){
        return parcoursService.update(p, id);
    }
}
