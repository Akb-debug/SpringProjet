package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.entity.Inscription;
import Tg.ipnet.FirstSpring.service.InscriptionService;

@RestController
@RequestMapping("api/v1/inscription")
@CrossOrigin("*")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/save")
    public Inscription create(@RequestBody Inscription i){
        return inscriptionService.create(i);
    }

    @GetMapping("/all")
    public List<Inscription> list(){
        return inscriptionService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        inscriptionService.delete(id);
    }

    @GetMapping("/one/{id}")
    public Inscription getInscription(@PathVariable Long id){
        return inscriptionService.getInscription(id);
    }

    @PutMapping("/update/{id}")
    public Inscription update(@RequestBody Inscription i, @PathVariable Long id){
        return inscriptionService.update(i, id);
    }
}
