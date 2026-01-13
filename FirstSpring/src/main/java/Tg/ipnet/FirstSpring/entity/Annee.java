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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="annee")
@EntityListeners(AuditingEntityListener.class)
public class Annee extends BaseEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @Column(name="date_debut", nullable=false, updatable = false)
	private LocalDateTime dateDebut;
	
	 @Column(name="date_fin", nullable=false, updatable = false)
	private LocalDateTime dateFin;
	
	 @Column(name="est_active",unique=true)
	private Boolean estActive;
	 
	 @OneToMany(mappedBy = "annee")
	 private List<Inscription> inscription = new ArrayList<>();
	 
	 @OneToMany(mappedBy="annee")
	 private List<Programme> programme = new ArrayList<>();

	public Annee() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getEstActive() {
		return estActive;
	}

	public void setEstActive(Boolean estActive) {
		this.estActive = estActive;
	}
	
	

}
