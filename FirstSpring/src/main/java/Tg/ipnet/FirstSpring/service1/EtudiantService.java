package Tg.ipnet.FirstSpring.service1;

import java.util.List;

import Tg.ipnet.FirstSpring.dto.EtudiantDTO;



public interface EtudiantService {
	 public EtudiantDTO create(EtudiantDTO e);

	    public EtudiantDTO update(EtudiantDTO e, Long id);

	    public void delete(Long id);

	    public List<EtudiantDTO> list();

	    public EtudiantDTO getEtudiant(Long id);

}
