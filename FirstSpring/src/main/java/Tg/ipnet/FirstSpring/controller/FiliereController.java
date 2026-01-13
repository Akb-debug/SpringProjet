package Tg.ipnet.FirstSpring.controller;
import Tg.ipnet.FirstSpring.service.FiliereServiceImp;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tg.ipnet.FirstSpring.entity.Filiere;
import Tg.ipnet.FirstSpring.service.FiliereService;

@RestController
@RequestMapping(path="api/v1/filiere")
@CrossOrigin("*")
public class FiliereController {

	
	private final FiliereService filiereService;
	
	public FiliereController(FiliereService filiereService) {
		this.filiereService = filiereService;
	}
	
	//cree des methodes 
	@PostMapping("/save")
	public Filiere create(@RequestBody Filiere f){
		return filiereService.create(f);
	}
	
	
	@GetMapping("/all")
	public List<Filiere> list(){
		return filiereService.list();
	}
	
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		filiereService.delete(id);
	}
	
	@GetMapping("one/{id}")
	public Filiere getFiliere(@PathVariable("id")Long id) {
		return filiereService.getFiliere(id);
	}
	

}
