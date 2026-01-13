package Tg.ipnet.FirstSpring.service1;

import java.util.List;

import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;

public interface ProgrammeService {

    ProgrammeDTO save(ProgrammeDTO dto);

    ProgrammeDTO update(Long id, ProgrammeDTO dto);

    ProgrammeDTO findById(Long id);

    List<ProgrammeDTO> findAll();

    void delete(Long id);
}
