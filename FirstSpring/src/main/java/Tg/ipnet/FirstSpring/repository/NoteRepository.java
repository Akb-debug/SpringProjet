package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.Note;

public interface NoteRepository  extends JpaRepository<Note,Long>{
	
	
	@Query("SELECT n FROM Note n order By n.noteObtenue")
	public List<Note> listNote();
	
	@Query(value="SELECT * FROM note  order By noteObtenue", nativeQuery=true)
	public List<Note> listNotesql();

	
	

}
