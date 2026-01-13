package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.Annee;

public interface AnneeService {

    public Annee create(Annee a);

    public Annee update(Annee a, Long id);

    public void delete(Long id);

    public List<Annee> list();

    public Annee getAnnee(Long id);
}
