package Tg.ipnet.FirstSpring.service;

import java.util.List;

import Tg.ipnet.FirstSpring.entity.Filiere;

public interface FiliereService {
	
	public Filiere create(Filiere f);
	
	public Filiere update(Filiere f,Long id);
	
	public void delete(Long id);
	
	public List <Filiere> list();
	
	public Filiere getFiliere(Long id);

}
