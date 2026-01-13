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
@Table(name="ue")
@EntityListeners(AuditingEntityListener.class)
public class Ue extends BaseEntity{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="code_ue", nullable = false)
	private String codeUE;
	
	@Column(name="intitule_ue", nullable = false)
	private String intituleUE;
	
	public String getCodeUE() {
		return codeUE;
	}

	public void setCodeUE(String codeUE) {
		this.codeUE = codeUE;
	}

	public String getIntituleUE() {
		return intituleUE;
	}

	public void setIntituleUE(String intituleUE) {
		this.intituleUE = intituleUE;
	}

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	public TypeUE getTypeUE() {
		return typeUE;
	}

	public void setTypeUE(TypeUE typeUE) {
		this.typeUE = typeUE;
	}

	public List<Programme> getProgramme() {
		return programme;
	}

	public void setProgramme(List<Programme> programme) {
		this.programme = programme;
	}

	public Parcours getParcours() {
		return parcours;
	}

	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}


	@Column(name="credit", nullable = false)
	private Double credit;
	
	@OneToMany(mappedBy="ue")
	private List<Note> note = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="type_ue_id" , nullable = false)
	private TypeUE typeUE ;
	
	@OneToMany(mappedBy="ue")
	private List<Programme> programme = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="parcours_id", nullable = false)
	private Parcours parcours;

	public Ue() {
		super();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodeUe() {
		return codeUE;
	}


	public void setCodeUe(String codeUE) {
		this.codeUE = codeUE;
	}


	public String getIntituleUe() {
		return intituleUE;
	}


	public void setIntituleUe(String intituleUE) {
		this.intituleUE = intituleUE;
	}


	public Double getCredit() {
		return credit;
	}


	public void setCredit(Double credit) {
		this.credit = credit;
	}

}
