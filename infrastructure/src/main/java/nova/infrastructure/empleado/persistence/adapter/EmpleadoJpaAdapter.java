package nova.infrastructure.empleado.persistence.adapter;

import lombok.RequiredArgsConstructor;
import nova.domain.empleado.model.Empleado;
import nova.domain.empleado.port.EmpleadoDao;
import nova.infrastructure.empleado.persistence.query.PersonaQuery;
import nova.infrastructure.empleado.persistence.repository.EmpleadoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EmpleadoJpaAdapter implements EmpleadoDao {
    private final EmpleadoRepository repository;

    @Override
    public List<Empleado> obtenerPorPuesto(Integer IDPuesto, Boolean activo) {
        return repository.findByPuestoIdAndActivo(IDPuesto, activo, PersonaQuery.class).stream().map(x -> new Empleado(x.id(), x.personaNombre())).toList();
    }
}
