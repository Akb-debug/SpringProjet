package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Tg.ipnet.FirstSpring.dto.ParcoursDTO;
import Tg.ipnet.FirstSpring.entity.Parcours;

@Mapper(componentModel = "spring")
public interface ParcoursMapper {

	@Mapping(target = "id", ignore = true)
    @Mapping(source = "filiere.id", target = "filiereId")
    ParcoursDTO toDto(Parcours parcours);

    @Mapping(source = "filiereId", target = "filiere.id" )
    Parcours toEntity(ParcoursDTO dto);
}
