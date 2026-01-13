package Tg.ipnet.FirstSpring.controller1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tg.ipnet.FirstSpring.dto.EtudiantDTO;
import Tg.ipnet.FirstSpring.service1.EtudiantService;

@RestController("etudiantControllerV2")
@RequestMapping("api/v2/etudiant/")
public class EtudiantController {
	private final EtudiantService service ;

	public EtudiantController(EtudiantService service) {
		super();
		this.service = service;
	}

	@PostMapping("save")
	public EtudiantDTO save(@RequestBody EtudiantDTO dto) {
		return service.create(dto);
	}
	
	@PutMapping("update/{id}")
	public EtudiantDTO update(@RequestBody EtudiantDTO dto, @PathVariable Long id) {
		return service.update(dto, id);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("liste")
	public List<EtudiantDTO> listeEtudiant(){
		return service.list();
	}
	
	@GetMapping("one/{id}")
	public EtudiantDTO getOneEtudiant(@PathVariable Long id) {
		return service.getEtudiant(id);
	}
}
