package nova.empresa.adapter;


import lombok.RequiredArgsConstructor;
import nova.empresa.Puesto;
import nova.empresa.port.PuestoPersistencePort;
import nova.empresa.repository.PuestoJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PuestoJpaAdapter implements PuestoPersistencePort {
    private final PuestoJpaRepository repositorio;

    @Override
    public List<Puesto> obtenerPuestos() {
        return repositorio.findAll().stream().map(x -> new Puesto(x.getId(), x.getNombre())).toList();
    }
}