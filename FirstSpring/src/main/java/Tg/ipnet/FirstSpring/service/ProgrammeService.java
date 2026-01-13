package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.Programme;

public interface ProgrammeService {

    public Programme create(Programme p);

    public Programme update(Programme p, Long id);

    public void delete(Long id);

    public List<Programme> list();

    public Programme getProgramme(Long id);
}
