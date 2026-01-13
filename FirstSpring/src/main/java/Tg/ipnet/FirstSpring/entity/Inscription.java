package Tg.ipnet.FirstSpring.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="inscription")
@EntityListeners(AuditingEntityListener.class)
public class Inscription extends BaseEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="date_inscription", nullable = false , updatable = true)
	private LocalDateTime dateInscription;
	
	@Column(name="etat_inscription", nullable = false , updatable = true)
	private String etatInscription;
	
	@Column(name="montant", nullable = false)
	private Double montant;
	
	@ManyToOne
	@JoinColumn(name="annee_id" , nullable = false)
	private Annee annee;
	
	public Annee getAnnee() {
		return annee;
	}


	public void setAnnee(Annee annee) {
		this.annee = annee;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Parcours getParcours() {
		return parcours;
	}


	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}


	public List<Note> getNote() {
		return note;
	}


	public void setNote(List<Note> note) {
		this.note = note;
	}


	@ManyToOne
	@JoinColumn(name="etudiant_id" , nullable = false)
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name="parcours_id" , nullable = false)
	private Parcours parcours;
	
	@OneToMany(mappedBy="inscription")
	private List<Note> note = new ArrayList<>();
	
	public Inscription() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getDateInscription() {
		return dateInscription;
	}


	public void setDateInscription(LocalDateTime dateInscription) {
		this.dateInscription = dateInscription;
	}


	public String getEtatInscription() {
		return etatInscription;
	}


	public void setEtatInscription(String etatInscription) {
		this.etatInscription = etatInscription;
	}


	public Double getMontant() {
		return montant;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	

}
