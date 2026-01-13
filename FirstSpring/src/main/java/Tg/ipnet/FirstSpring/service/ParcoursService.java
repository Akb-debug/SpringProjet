package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.Parcours;

public interface ParcoursService {

    public Parcours create(Parcours p);

    public Parcours update(Parcours p, Long id);

    public void delete(Long id);

    public List<Parcours> list();

    public Parcours getParcours(Long id);
}
