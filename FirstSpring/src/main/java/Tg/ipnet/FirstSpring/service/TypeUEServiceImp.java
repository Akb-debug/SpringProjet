package Tg.ipnet.FirstSpring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Tg.ipnet.FirstSpring.entity.TypeUE;
import Tg.ipnet.FirstSpring.repository.TypeUERepository;

@Service
@Transactional
public class TypeUEServiceImp implements TypeUEService {

    private final TypeUERepository typeUERepository;

    public TypeUEServiceImp(TypeUERepository typeUERepository) {
        this.typeUERepository = typeUERepository;
    }

    @Override
    public TypeUE create(TypeUE t) {
        return typeUERepository.save(t);
    }

    @Override
    public TypeUE update(TypeUE t, Long id) {
        TypeUE type = typeUERepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Type UE non trouvé"));
        type.setLibelle(t.getLibelle());
        type.setDescription(t.getDescription());
        return typeUERepository.save(type);
    }

    @Override
    public void delete(Long id) {
        typeUERepository.deleteById(id);
    }

    @Override
    public List<TypeUE> list() {
        return typeUERepository.findAll();
    }

    @Override
    public TypeUE getTypeUE(Long id) {
        return typeUERepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Type UE non trouvé"));
    }
}
