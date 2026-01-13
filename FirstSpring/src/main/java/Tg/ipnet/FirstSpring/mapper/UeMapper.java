package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Tg.ipnet.FirstSpring.dto.UeDTO;
import Tg.ipnet.FirstSpring.entity.Ue;

@Mapper(componentModel = "spring")
public interface UeMapper {

    // Entity → DTO
    @Mapping(target = "typeUEId", ignore = true)
    @Mapping(target = "parcoursId", ignore = true)
    UeDTO toDto(Ue ue);

    // DTO → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "typeUE", ignore = true)
    @Mapping(target = "parcours", ignore = true)
    @Mapping(target = "note", ignore = true)
    @Mapping(target = "programme", ignore = true)
    Ue toEntity(UeDTO dto);
}
