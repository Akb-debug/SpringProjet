package Tg.ipnet.FirstSpring.dto;

import java.time.LocalDateTime;

public class AnneeDTO {

    private Long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Boolean estActive;

    public AnneeDTO() {}

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
