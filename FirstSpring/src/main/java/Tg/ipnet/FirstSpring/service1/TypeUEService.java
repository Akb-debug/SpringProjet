package Tg.ipnet.FirstSpring.service1;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.TypeUEDTO;

public interface TypeUEService {

    TypeUEDTO create(TypeUEDTO dto);

    TypeUEDTO update(Long id, TypeUEDTO dto);

    TypeUEDTO getById(Long id);

    List<TypeUEDTO> list();

    void delete(Long id);
}
