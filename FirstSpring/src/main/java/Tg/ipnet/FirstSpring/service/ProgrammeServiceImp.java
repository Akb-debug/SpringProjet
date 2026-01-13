package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Tg.ipnet.FirstSpring.entity.Programme;
import Tg.ipnet.FirstSpring.repository.ProgrammeRepository;

@Service
@Transactional
public class ProgrammeServiceImp implements ProgrammeService {

    private final ProgrammeRepository programmeRepository;

    public ProgrammeServiceImp(ProgrammeRepository programmeRepository) {
        this.programmeRepository = programmeRepository;
    }

    @Override
    public Programme create(Programme p) {
        return programmeRepository.save(p);
    }

    @Override
    public Programme update(Programme p, Long id) {
        Programme prog = programmeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Programme non trouvé"));
        prog.setLibelle(p.getLibelle());
        prog.setDescription(p.getDescription());
        prog.setParcours(p.getParcours());
        prog.setAnnee(p.getAnnee());
        prog.setUe(p.getUe());
        return programmeRepository.save(prog);
    }

    @Override
    public void delete(Long id) {
        programmeRepository.deleteById(id);
    }

    @Override
    public List<Programme> list() {
        return programmeRepository.findAll();
    }

    @Override
    public Programme getProgramme(Long id) {
        return programmeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Programme non trouvé"));
    }
}
