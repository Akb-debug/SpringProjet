package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.Etudiant;

public interface EtudiantService {

    public Etudiant create(Etudiant e);

    public Etudiant update(Etudiant e, Long id);

    public void delete(Long id);

    public List<Etudiant> list();

    public Etudiant getEtudiant(Long id);
}
