package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Tg.ipnet.FirstSpring.entity.Annee;
import Tg.ipnet.FirstSpring.repository.AnneeRepository;

@Service
@Transactional
public class AnneeServiceImp implements AnneeService {

    private final AnneeRepository anneeRepository;

    public AnneeServiceImp(AnneeRepository anneeRepository) {
        this.anneeRepository = anneeRepository;
    }

    @Override
    public Annee create(Annee a) {
        return anneeRepository.save(a);
    }

    @Override
    public Annee update(Annee a, Long id) {
        Annee annee = anneeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Annee non trouvée"));
        annee.setDateDebut(a.getDateDebut());
        annee.setDateFin(a.getDateFin());
        annee.setEstActive(a.getEstActive());
        return anneeRepository.save(annee);
    }

    @Override
    public void delete(Long id) {
        anneeRepository.deleteById(id);
    }

    @Override
    public List<Annee> list() {
        return anneeRepository.findAll();
    }

    @Override
    public Annee getAnnee(Long id) {
        return anneeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Annee non trouvée"));
    }
}
