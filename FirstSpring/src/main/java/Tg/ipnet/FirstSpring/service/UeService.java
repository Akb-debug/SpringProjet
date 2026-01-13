package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.Ue;

public interface UeService {

    public Ue create(Ue u);

    public Ue update(Ue u, Long id);

    public void delete(Long id);

    public List<Ue> list();

    public Ue getUe(Long id);
}
