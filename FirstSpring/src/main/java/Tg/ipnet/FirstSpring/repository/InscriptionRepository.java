package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity. Inscription;

public interface InscriptionRepository extends JpaRepository< Inscription,Long>{
	
	
	@Query("SELECT i FROM  Inscription i order By i.dateInscription")
	public List< Inscription> listInscription();
	
	@Query(value="SELECT * FROM inscription  order By dateInscription", nativeQuery=true)
	public List< Inscription> listInscriptionsql();

	
	


}
