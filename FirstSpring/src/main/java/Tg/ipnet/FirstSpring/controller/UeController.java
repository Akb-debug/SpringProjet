package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.entity.Ue;
import Tg.ipnet.FirstSpring.service.UeService;

@RestController
@RequestMapping("api/v1/ue")
@CrossOrigin("*")
public class UeController {

    private final UeService ueService;

    public UeController(UeService ueService) {
        this.ueService = ueService;
    }

    @PostMapping("/save")
    public Ue create(@RequestBody Ue u){
        return ueService.create(u);
    }

    @GetMapping("/all")
    public List<Ue> list(){
        return ueService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ueService.delete(id);
    }

    @GetMapping("/one/{id}")
    public Ue getUe(@PathVariable Long id){
        return ueService.getUe(id);
    }

    @PutMapping("/update/{id}")
    public Ue update(@RequestBody Ue u, @PathVariable Long id){
        return ueService.update(u, id);
    }
}
