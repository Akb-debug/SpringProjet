package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.entity.TypeUE;

public interface TypeUEService {

    public TypeUE create(TypeUE t);

    public TypeUE update(TypeUE t, Long id);

    public void delete(Long id);

    public List<TypeUE> list();

    public TypeUE getTypeUE(Long id);
}
