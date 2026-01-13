package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import Tg.ipnet.FirstSpring.dto.AnneeDTO;
import Tg.ipnet.FirstSpring.entity.Annee;

@Mapper(componentModel = "spring")
public interface AnneeMapper {

    
    @Mapping(target = "id", ignore = true)
    AnneeDTO toDto(Annee annee);

    Annee toEntity(AnneeDTO anneeDTO);
}
