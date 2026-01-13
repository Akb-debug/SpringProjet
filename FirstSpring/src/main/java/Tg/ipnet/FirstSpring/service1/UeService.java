package Tg.ipnet.FirstSpring.service1;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.UeDTO;

public interface UeService {

    UeDTO create(UeDTO dto);

    UeDTO update(Long id, UeDTO dto);

    UeDTO getById(Long id);

    List<UeDTO> list();

    void delete(Long id);
}
