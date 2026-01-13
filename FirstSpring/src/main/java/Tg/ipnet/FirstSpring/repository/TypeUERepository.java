package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.TypeUE;

public interface TypeUERepository  extends JpaRepository<TypeUE,Long>{
	
	
	@Query("SELECT t FROM TypeUE t order By t.libelle")
	public List<TypeUE> listTypeUE();
	
	@Query(value="SELECT * FROM typeUE  order By libelle", nativeQuery=true)
	public List<TypeUE> listTypeUEsql();

	
	

}
