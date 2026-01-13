package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Tg.ipnet.FirstSpring.entity.Inscription;
import Tg.ipnet.FirstSpring.repository.InscriptionRepository;

@Service
@Transactional
public class InscriptionServiceImp implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    public InscriptionServiceImp(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription create(Inscription i) {
        return inscriptionRepository.save(i);
    }

    @Override
    public Inscription update(Inscription i, Long id) {
        Inscription insc = inscriptionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inscription non trouvée"));
        insc.setDateInscription(i.getDateInscription());
        insc.setEtatInscription(i.getEtatInscription());
        insc.setMontant(i.getMontant());
        insc.setAnnee(i.getAnnee());
        insc.setEtudiant(i.getEtudiant());
        insc.setParcours(i.getParcours());
        return inscriptionRepository.save(insc);
    }

    @Override
    public void delete(Long id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
    public List<Inscription> list() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription getInscription(Long id) {
        return inscriptionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inscription non trouvée"));
    }
}
