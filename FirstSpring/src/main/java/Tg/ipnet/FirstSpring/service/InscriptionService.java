package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.Inscription;

public interface InscriptionService {

    public Inscription create(Inscription i);

    public Inscription update(Inscription i, Long id);

    public void delete(Long id);

    public List<Inscription> list();

    public Inscription getInscription(Long id);
}
