package Tg.ipnet.FirstSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.entity.Etudiant;
import Tg.ipnet.FirstSpring.service.EtudiantService;

@RestController
@RequestMapping("api/v1/etudiant")
@CrossOrigin("*")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping("/save")
    public Etudiant create(@RequestBody Etudiant e){
        return etudiantService.create(e);
    }

    @GetMapping("/all")
    public List<Etudiant> list(){
        return etudiantService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        etudiantService.delete(id);
    }

    @GetMapping("/one/{id}")
    public Etudiant getEtudiant(@PathVariable("id") Long id) {
        return etudiantService.getEtudiant(id);
    }

    @PutMapping("/update/{id}")
    public Etudiant update(@RequestBody Etudiant e, @PathVariable Long id){
        return etudiantService.update(e, id);
    }
}
