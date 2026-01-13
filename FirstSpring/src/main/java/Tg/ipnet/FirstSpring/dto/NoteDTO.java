package Tg.ipnet.FirstSpring.dto;

import java.time.LocalDateTime;

public class NoteDTO {

    private Long id;
    private Double noteObtenue;
    private LocalDateTime dateObtention;
    private String typeEvaluation;

    // Relations (IDs uniquement)
    private Long ueId;
    private Long inscriptionId;
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
	public Long getUeId() {
		return ueId;
	}
	public void setUeId(Long ueId) {
		this.ueId = ueId;
	}
	public Long getInscriptionId() {
		return inscriptionId;
	}
	public void setInscriptionId(Long inscriptionId) {
		this.inscriptionId = inscriptionId;
	}
	public NoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
