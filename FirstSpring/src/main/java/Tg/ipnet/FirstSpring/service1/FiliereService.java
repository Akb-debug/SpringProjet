package Tg.ipnet.FirstSpring.service1;
import java.util.List;

import Tg.ipnet.FirstSpring.dto.FiliereDTO;

public interface FiliereService {

    FiliereDTO create(FiliereDTO dto);

    FiliereDTO update(FiliereDTO dto, Long id);

    void delete(Long id);

    FiliereDTO getById(Long id);

    List<FiliereDTO> list();
}
