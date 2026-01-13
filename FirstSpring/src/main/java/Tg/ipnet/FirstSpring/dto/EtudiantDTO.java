package Tg.ipnet.FirstSpring.dto;

import java.time.LocalDateTime;

public class EtudiantDTO {

    private String matricule;
    private String nom;
    private String prenom;
    private LocalDateTime dateNaissance;
    private String adresse;
    private String email;
    private String numtel;

    public EtudiantDTO() {
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
}
