package Tg.ipnet.FirstSpring.service1.impl;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import Tg.ipnet.FirstSpring.dto.EtudiantDTO;
import Tg.ipnet.FirstSpring.entity.Etudiant;
import Tg.ipnet.FirstSpring.mapper.EtudiantMapper;
import Tg.ipnet.FirstSpring.repository.EtudiantRepository;
import Tg.ipnet.FirstSpring.service1.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService	 {
	
	private final EtudiantRepository etudiantRep ;
	
	private final EtudiantMapper mapper;

	public EtudiantServiceImpl(EtudiantRepository etudiantRep, EtudiantMapper mapper) {
		super();
		this.etudiantRep = etudiantRep;
		this.mapper = mapper;
	}

	@Override
	public EtudiantDTO create(EtudiantDTO e) {
		Etudiant etudiant = mapper.toEntity(e);
		Etudiant save = etudiantRep.save(etudiant);
		return  mapper.toDto(save);
	}

	@Override
	public EtudiantDTO update(EtudiantDTO dto, Long id) {

	    Etudiant etudiant = etudiantRep.findById(id)
	            .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

	    etudiant.setMatricule(dto.getMatricule());
	    etudiant.setNom(dto.getNom());
	    etudiant.setPrenom(dto.getPrenom());
	    etudiant.setDateNaissance(dto.getDateNaissance());
	    etudiant.setAdresse(dto.getAdresse());
	    etudiant.setEmail(dto.getEmail());
	    etudiant.setNumtel(dto.getNumtel());

	    Etudiant updated = etudiantRep.save(etudiant);

	    return mapper.toDto(updated);
	}


	@Override
	public void delete(Long id) {
		if (!etudiantRep.existsById(id)) {
            throw new RuntimeException("Etudiant introuvable");
        }
		etudiantRep.deleteById(id);	
	}

	@Override
	public List<EtudiantDTO> list() {
		List<Etudiant> listEtudiant = etudiantRep.findAll();
		List<EtudiantDTO> resultat = new ArrayList<EtudiantDTO>();
		
		for(Etudiant e : listEtudiant) {
			resultat.add(mapper.toDto(e));
		}
		return resultat;
	}

	@Override
	public EtudiantDTO getEtudiant(Long id) {
		Etudiant etudiant = etudiantRep.findById(id).orElseThrow(() -> new RuntimeException("Étudiant introuvable"));
		return mapper.toDto(etudiant);
	}

}
