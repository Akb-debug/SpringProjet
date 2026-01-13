package Tg.ipnet.FirstSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Tg.ipnet.FirstSpring.dto.NoteDTO;
import Tg.ipnet.FirstSpring.entity.Note;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    @Mapping(source = "ue.id", target = "ueId")
    @Mapping(source = "inscription.id", target = "inscriptionId")
    NoteDTO toDto(Note note);

    @Mapping(target = "ue", ignore = true)
    @Mapping(target = "inscription", ignore = true)
    Note toEntity(NoteDTO dto);
}
