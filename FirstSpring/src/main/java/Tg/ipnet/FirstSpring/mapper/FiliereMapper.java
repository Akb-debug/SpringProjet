package Tg.ipnet.FirstSpring.mapper;
import org.mapstruct.Mapper;

import Tg.ipnet.FirstSpring.dto.FiliereDTO;
import Tg.ipnet.FirstSpring.entity.Filiere;

@Mapper(componentModel = "spring")
public interface FiliereMapper {

    FiliereDTO toDto(Filiere filiere);

    Filiere toEntity(FiliereDTO dto);
}
