package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.Ue;

public interface UERepository  extends JpaRepository<Ue,Long>{
	
	
	@Query("SELECT u FROM Ue u order By u.intituleUE")
	public List<Ue> listTypeUE();
	
	@Query(value="SELECT * FROM ue  order By intituleUE", nativeQuery=true)
	public List<Ue> listTypeUEsql();
	
	
	

}
