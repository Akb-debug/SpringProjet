package Tg.ipnet.FirstSpring.entity;

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
@Table(name="parcours")
@EntityListeners(AuditingEntityListener.class)
public class Parcours extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nom", nullable = false , unique =true , length = 255)
	private String nom;
	
	@Column(name="nbr_semestre", nullable = false , unique =true , length = 255)
	private Long nbrSemestre; 
	
	@ManyToOne 
	@JoinColumn(name="filiere_id", nullable = false)
	private Filiere filiere;
	
	@OneToMany(mappedBy="parcours")
	private List<Inscription> inscription = new ArrayList<>();
	
	@OneToMany(mappedBy="parcours")
	private List<Programme> programme = new ArrayList<>();
	
	@OneToMany(mappedBy="parcours")
	private List<Ue> ue = new ArrayList<>();	
	

	public Parcours() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Long getNbrSemestre() {
		return nbrSemestre;
	}


	public void setNbrSemestre(Long nbrSemestre) {
		this.nbrSemestre = nbrSemestre;
	}


	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public List<Inscription> getInscription() {
		return inscription;
	}


	public void setInscription(List<Inscription> inscription) {
		this.inscription = inscription;
	}


	public List<Programme> getProgramme() {
		return programme;
	}


	public void setProgramme(List<Programme> programme) {
		this.programme = programme;
	}


	public List<Ue> getUe() {
		return ue;
	}


	public void setUe(List<Ue> ue) {
		this.ue = ue;
	}


	}


	
	
	
	
	


