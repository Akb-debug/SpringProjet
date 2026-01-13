package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.Programme;

public interface ProgrammeRepository extends  JpaRepository<Programme,Long> {
	
	
	@Query("SELECT p FROM Programme p order By p.libelle")
	public List<Programme> listProgramme();
	
	@Query(value="SELECT * FROM programme  order By libelle", nativeQuery=true)
	public List<Programme> listProgrammesql();

	
	

}
