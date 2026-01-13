package Tg.ipnet.FirstSpring.service1.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.InscriptionDTO;
import Tg.ipnet.FirstSpring.entity.Annee;
import Tg.ipnet.FirstSpring.entity.Etudiant;
import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.entity.Inscription;
import Tg.ipnet.FirstSpring.mapper.InscriptionMapper;
import Tg.ipnet.FirstSpring.repository.InscriptionRepository;
import Tg.ipnet.FirstSpring.repository.AnneeRepository;
import Tg.ipnet.FirstSpring.repository.EtudiantRepository;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;
import Tg.ipnet.FirstSpring.service1.InscriptionService;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository repository;
    private final InscriptionMapper mapper;
    private final AnneeRepository anneeRep;
    private final EtudiantRepository etudiantRep;
    private final ParcoursRepository parcoursRep;

    public InscriptionServiceImpl(InscriptionRepository repository, InscriptionMapper mapper,
                                  AnneeRepository anneeRep, EtudiantRepository etudiantRep,
                                  ParcoursRepository parcoursRep) {
        this.repository = repository;
        this.mapper = mapper;
        this.anneeRep = anneeRep;
        this.etudiantRep = etudiantRep;
        this.parcoursRep = parcoursRep;
    }

    @Override
    public InscriptionDTO create(InscriptionDTO dto) {
        Inscription i = new Inscription();
        i.setDateInscription(dto.getDateInscription());
        i.setEtatInscription(dto.getEtatInscription());
        i.setMontant(dto.getMontant());
        i.setAnnee(anneeRep.findById(dto.getAnneeId())
            .orElseThrow(() -> new RuntimeException("Année introuvable")));
        i.setEtudiant(etudiantRep.findById(dto.getEtudiantId())
            .orElseThrow(() -> new RuntimeException("Etudiant introuvable")));
        i.setParcours(parcoursRep.findById(dto.getParcoursId())
            .orElseThrow(() -> new RuntimeException("Parcours introuvable")));

        return mapper.toDto(repository.save(i));
    }

    @Override
    public InscriptionDTO update(InscriptionDTO dto, Long id) {
        Inscription i = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription introuvable"));
        i.setDateInscription(dto.getDateInscription());
        i.setEtatInscription(dto.getEtatInscription());
        i.setMontant(dto.getMontant());
        i.setAnnee(anneeRep.findById(dto.getAnneeId())
            .orElseThrow(() -> new RuntimeException("Année introuvable")));
        i.setEtudiant(etudiantRep.findById(dto.getEtudiantId())
            .orElseThrow(() -> new RuntimeException("Etudiant introuvable")));
        i.setParcours(parcoursRep.findById(dto.getParcoursId())
            .orElseThrow(() -> new RuntimeException("Parcours introuvable")));

        return mapper.toDto(repository.save(i));
    }

    @Override
    public List<InscriptionDTO> list() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public InscriptionDTO get(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription introuvable")));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
