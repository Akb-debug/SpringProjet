package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.Filiere;

public interface FiliereRepository  extends JpaRepository<Filiere,Long>{
	
	
	@Query("SELECT f FROM Filiere f order By f.nom")
	public List<Filiere> listFiliere();
	
	@Query(value="SELECT * FROM filiere  order By nom", nativeQuery=true)
	public List<Filiere> listFilieresql();
	
	 boolean existsByNom(String nom);

	
	

}
