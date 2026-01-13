package Tg.ipnet.FirstSpring.dto;

import java.time.LocalDateTime;

public class InscriptionDTO {

    private Long id;
    private LocalDateTime dateInscription;
    private String etatInscription;
    private Double montant;
    
    private Long anneeId;     // On expose juste l'id
    private Long etudiantId;
    private Long parcoursId;

    // Getters & Setters
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
    public Long getAnneeId() {
        return anneeId;
    }
    public void setAnneeId(Long anneeId) {
        this.anneeId = anneeId;
    }
    public Long getEtudiantId() {
        return etudiantId;
    }
    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }
    public Long getParcoursId() {
        return parcoursId;
    }
    public void setParcoursId(Long parcoursId) {
        this.parcoursId = parcoursId;
    }
}
