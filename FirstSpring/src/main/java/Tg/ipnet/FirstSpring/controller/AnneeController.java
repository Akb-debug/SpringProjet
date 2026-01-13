package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.entity.Annee;
import Tg.ipnet.FirstSpring.service.AnneeService;

@RestController
@RequestMapping("api/v1/annee")
@CrossOrigin("*")
public class AnneeController {

    private final AnneeService anneeService;

    public AnneeController(AnneeService anneeService) {
        this.anneeService = anneeService;
    }

    @PostMapping("/save")
    public Annee create(@RequestBody Annee a){
        return anneeService.create(a);
    }

    @GetMapping("/all")
    public List<Annee> list(){
        return anneeService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        anneeService.delete(id);
    }

    @GetMapping("/one/{id}")
    public Annee getAnnee(@PathVariable("id") Long id) {
        return anneeService.getAnnee(id);
    }

    @PutMapping("/update/{id}")
    public Annee update(@RequestBody Annee a, @PathVariable Long id){
        return anneeService.update(a, id);
    }

    
}
