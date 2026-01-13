package Tg.ipnet.FirstSpring.service1;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.AnneeDTO;

public interface AnneeService {

    AnneeDTO create(AnneeDTO dto);

    AnneeDTO update(AnneeDTO dto, Long id);

    void delete(Long id);

    List<AnneeDTO> list();

    AnneeDTO getAnnee(Long id);
}
