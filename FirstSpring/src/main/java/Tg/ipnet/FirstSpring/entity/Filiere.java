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
@Table(name="filiere")
@EntityListeners(AuditingEntityListener.class)
public class Filiere extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="nom", nullable = false , unique =true , length = 255)
	private String nom;
	
	@Column(name="description", nullable = false , unique =true , length = 255)
	private String description; 
	
	@OneToMany(mappedBy = "filiere")
	private List<Parcours> parcours = new ArrayList<>();
	
	
	public Filiere() {
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}
	
	

}
