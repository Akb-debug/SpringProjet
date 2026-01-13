package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.entity.Etudiant;
import Tg.ipnet.FirstSpring.repository.EtudiantRepository;

@Service
@Transactional
public class EtudiantServiceImp implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImp(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant create(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant update(Etudiant e, Long id) {
        Etudiant etudiant = etudiantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));
        etudiant.setMatricule(e.getMatricule());
        etudiant.setNom(e.getNom());
        etudiant.setPrenom(e.getPrenom());
        etudiant.setDateNaissance(e.getDateNaissance());
        etudiant.setAdresse(e.getAdresse());
        etudiant.setEmail(e.getEmail());
        etudiant.setNumtel(e.getNumtel());
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> list() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiant(Long id) {
        return etudiantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));
    }
}
