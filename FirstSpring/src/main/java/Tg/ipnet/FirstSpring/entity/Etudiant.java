package Tg.ipnet.FirstSpring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import Tg.ipnet.FirstSpring.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="etudiant")
@EntityListeners(AuditingEntityListener.class)
public class Etudiant extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "matricule" , nullable = false , unique = true)
	private String matricule;
	
	@Column(name = "nom" , nullable = false)
	private String nom;
	
	@Column(name = "prenom" , nullable = false)
	private String prenom;
	
	@Column(name = "date_naissance" , nullable = false)
	private LocalDateTime dateNaissance;
	
	@Column(name = "adresse" , nullable = false)
	private String adresse;
	
	@Column(name="email", nullable = false , unique = true)
	private String email;
	
	@Column(name = "num_tel" , nullable = false) 
	private String numtel;
	
	@OneToMany(mappedBy = "etudiant")
	private List<Inscription> inscription = new ArrayList<>();
	
	
	public Etudiant() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDateTime getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDateTime dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", email=" + email + ", numtel="
				+ numtel + "]";
	}
	
	

}