package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import Tg.ipnet.FirstSpring.dto.InscriptionDTO;
import Tg.ipnet.FirstSpring.entity.Inscription;

@Mapper(componentModel = "spring")
public interface InscriptionMapper {

    @Mapping(source = "annee.id", target = "anneeId")
    @Mapping(source = "etudiant.id", target = "etudiantId")
    @Mapping(source = "parcours.id", target = "parcoursId")
    InscriptionDTO toDto(Inscription inscription);

    // Ici pour créer l'entité à partir du DTO, tu devras récupérer les entités Annee, Etudiant et Parcours
    Inscription toEntity(InscriptionDTO dto);
}
