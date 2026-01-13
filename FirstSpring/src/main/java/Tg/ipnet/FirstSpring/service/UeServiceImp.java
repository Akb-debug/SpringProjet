package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Tg.ipnet.FirstSpring.entity.Ue;
import Tg.ipnet.FirstSpring.repository.UERepository;

@Service
@Transactional
public class UeServiceImp implements UeService {

    private final UERepository ueRepository;

    public UeServiceImp(UERepository ueRepository) {
        this.ueRepository = ueRepository;
    }

    @Override
    public Ue create(Ue u) {
        return ueRepository.save(u);
    }

    @Override
    public Ue update(Ue u, Long id) {
        Ue ue = ueRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("UE non trouvée"));
        ue.setCodeUe(u.getCodeUe());
        ue.setIntituleUe(u.getIntituleUe());
        ue.setCredit(u.getCredit());
        ue.setTypeUE(u.getTypeUE());
        ue.setParcours(u.getParcours());
        return ueRepository.save(ue);
    }

    @Override
    public void delete(Long id) {
        ueRepository.deleteById(id);
    }

    @Override
    public List<Ue> list() {
        return ueRepository.findAll();
    }

    @Override
    public Ue getUe(Long id) {
        return ueRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("UE non trouvée"));
    }
}
