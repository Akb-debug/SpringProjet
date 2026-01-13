package Tg.ipnet.FirstSpring.service1;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.InscriptionDTO;

public interface InscriptionService {

    InscriptionDTO create(InscriptionDTO dto);

    InscriptionDTO update(InscriptionDTO dto, Long id);

    List<InscriptionDTO> list();

    InscriptionDTO get(Long id);

    void delete(Long id);
}
