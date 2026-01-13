package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Tg.ipnet.FirstSpring.dto.TypeUEDTO;
import Tg.ipnet.FirstSpring.entity.TypeUE;

@Mapper(componentModel = "spring")
public interface TypeUEMapper {

	
    TypeUEDTO toDto(TypeUE typeUE);

  
    @Mapping(target = "id", ignore = true)
    TypeUE toEntity(TypeUEDTO dto);
}
