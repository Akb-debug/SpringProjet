package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{
	
	
	@Query("SELECT e FROM Etudiant e order By e.nom")
	public List<Etudiant> listEtudiant();
	
	@Query(value="SELECT * FROM etudiant  order By nom", nativeQuery=true)
	public List<Etudiant> listEtudiantsql();

	
	


}
