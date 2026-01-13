package Tg.ipnet.FirstSpring.entity;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import Tg.ipnet.FirstSpring.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="note")
@EntityListeners(AuditingEntityListener.class)
public class Note extends BaseEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Ue getUe() {
		return ue;
	}



	public void setUe(Ue ue) {
		this.ue = ue;
	}



	public Inscription getInscription() {
		return inscription;
	}



	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}



	@Column(name="note_obtenue", nullable = false)
	private Double noteObtenue;
	
	@Column(name="date_obtention", nullable = false)
	private LocalDateTime dateObtention;
	
	@Column(name="type_evaluation", nullable = false)
	private String typeEvaluation ; 
	
	@ManyToOne
	@JoinColumn(name="ue_id", nullable = false)
	private Ue ue;
	
	@ManyToOne
	@JoinColumn(name="inscription_id", nullable = false)
	private Inscription inscription;

	

	public Note() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getNoteObtenue() {
		return noteObtenue;
	}



	public void setNoteObtenue(Double noteObtenue) {
		this.noteObtenue = noteObtenue;
	}



	public LocalDateTime getDateObtention() {
		return dateObtention;
	}



	public void setDateObtention(LocalDateTime dateObtention) {
		this.dateObtention = dateObtention;
	}



	public String getTypeEvaluation() {
		return typeEvaluation;
	}



	public void setTypeEvaluation(String typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}
	
		

	
	

}
