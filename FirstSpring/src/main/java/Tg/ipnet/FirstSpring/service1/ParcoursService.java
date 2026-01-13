package Tg.ipnet.FirstSpring.service1;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.ParcoursDTO;

public interface ParcoursService {

    ParcoursDTO create(ParcoursDTO dto);

    ParcoursDTO update(ParcoursDTO dto, Long id);

    List<ParcoursDTO> list();

    ParcoursDTO get(Long id);

    void delete(Long id);
}
