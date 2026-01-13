package Tg.ipnet.FirstSpring.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.entity.Filiere;
import Tg.ipnet.FirstSpring.repository.FiliereRepository;
@Service
@Transactional
public class FiliereServiceImp implements FiliereService {
	
	private final FiliereRepository filiereRepository; 
	
	public FiliereServiceImp  (FiliereRepository filiereRepository) {
		this.filiereRepository = filiereRepository;
	}
	

	@Override
	public Filiere create(Filiere f) {
		// TODO Auto-generated method stub
		return filiereRepository.save(f);
	}

	@Override
	public Filiere update(Filiere f, Long id) {
		Filiere filiere = filiereRepository.findById(id).orElseThrow(()-> new RuntimeException("filiere non trouvé"));
		filiere.setNom(f.getNom());
		return filiereRepository.save(filiere);
	}

	@Override
	public void delete(Long id) {
		filiereRepository.deleteById(id);
	}

	@Override
	public List<Filiere> list() {
		// TODO Auto-generated method stub
		return filiereRepository.listFiliere() ;
	}

	@Override
	public Filiere getFiliere(Long id) {
		// TODO Auto-generated method stub
		return filiereRepository.findById(id).orElseThrow(null);
	}



}
