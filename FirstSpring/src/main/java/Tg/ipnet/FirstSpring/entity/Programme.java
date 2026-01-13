package Tg.ipnet.FirstSpring.entity;

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
@Table(name="programme")
@EntityListeners(AuditingEntityListener.class)
public class Programme extends BaseEntity {
	public Parcours getParcours() {
		return parcours;
	}


	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}


	public Annee getAnnee() {
		return annee;
	}


	public void setAnnee(Annee annee) {
		this.annee = annee;
	}


	public Ue getUe() {
		return ue;
	}


	public void setUe(Ue ue) {
		this.ue = ue;
	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="libelle", nullable=false)
	private String libelle; 
	
	@Column(name="descrription", nullable=false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="parcours_id", nullable=false)
	private Parcours parcours;
	
	@ManyToOne
	@JoinColumn(name="annee_id", nullable = false)
	private Annee annee;
	
	@ManyToOne
	@JoinColumn(name="ue_id", nullable = false)
	private Ue ue;

	public Programme() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
}
