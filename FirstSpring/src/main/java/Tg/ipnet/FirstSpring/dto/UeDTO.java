package Tg.ipnet.FirstSpring.dto;

public class UeDTO {

    private String codeUE;
    private String intituleUE;
    private Double credit;

    private Long typeUEId;
    private Long parcoursId;
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
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Long getTypeUEId() {
		return typeUEId;
	}
	public void setTypeUEId(Long typeUEId) {
		this.typeUEId = typeUEId;
	}
	public Long getParcoursId() {
		return parcoursId;
	}
	public void setParcoursId(Long parcoursId) {
		this.parcoursId = parcoursId;
	}
	public UeDTO() {
		super();
		
	}

    
}
