package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.Parcours;

public interface ParcoursRepository extends JpaRepository<Parcours,Long>{
	
	
	@Query("SELECT p FROM Parcours p order By p.nom")
	public List<Parcours> listParcours();
	
	@Query(value="SELECT * FROM Parcours  order By nom", nativeQuery=true)
	public List<Parcours> listParcoursql();

	
	


}
