package nova.infrastructure.empresa.persistence.adapter;


import lombok.RequiredArgsConstructor;
import nova.core.empresa.Puesto;
import nova.domain.empresa.port.PuestoDao;
import nova.infrastructure.empresa.persistence.repository.PuestoJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PuestoJpaAdapter implements PuestoDao {
    private final PuestoJpaRepository repositorio;

    @Override
    public List<Puesto> obtenerPuestos() {
        return repositorio.findAll().stream().map(x -> new Puesto(x.getId(), x.getNombre())).toList();
    }
}