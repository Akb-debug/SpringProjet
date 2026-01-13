package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;

@Service
@Transactional
public class ParcoursServiceImp implements ParcoursService {

    private final ParcoursRepository parcoursRepository;

    public ParcoursServiceImp(ParcoursRepository parcoursRepository) {
        this.parcoursRepository = parcoursRepository;
    }

    @Override
    public Parcours create(Parcours p) {
        return parcoursRepository.save(p);
    }

    @Override
    public Parcours update(Parcours p, Long id) {
        Parcours parcours = parcoursRepository.findById(id).orElseThrow(() -> new RuntimeException("Parcours non trouvé"));
        parcours.setNom(p.getNom());
        parcours.setNbrSemestre(p.getNbrSemestre());
        return parcoursRepository.save(parcours);
    }

    @Override
    public void delete(Long id) {
        parcoursRepository.deleteById(id);
    }

    @Override
    public List<Parcours> list() {
        return parcoursRepository.findAll();
    }

    @Override
    public Parcours getParcours(Long id) {
        return parcoursRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Parcours non trouvé"));
    }
}
