package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;

import Tg.ipnet.FirstSpring.dto.EtudiantDTO;
import Tg.ipnet.FirstSpring.entity.Etudiant;


@Mapper(componentModel = "spring")
public interface EtudiantMapper {

    EtudiantDTO  toDto(Etudiant etudiant);

    Etudiant toEntity(EtudiantDTO etudiantDto);

}
