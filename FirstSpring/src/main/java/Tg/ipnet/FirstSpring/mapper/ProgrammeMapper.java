package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;
import Tg.ipnet.FirstSpring.entity.Programme;

@Mapper(componentModel = "spring")
public interface ProgrammeMapper {

    @Mapping(source = "parcours.id", target = "parcoursId")
    @Mapping(source = "annee.id", target = "anneeId")
    @Mapping(source = "ue.id", target = "ueId")
    ProgrammeDTO toDto(Programme programme);

    
    @Mapping(target = "parcours", ignore = true)
    @Mapping(target = "annee", ignore = true)
    @Mapping(target = "ue", ignore = true)
    Programme toEntity(ProgrammeDTO dto);
}
