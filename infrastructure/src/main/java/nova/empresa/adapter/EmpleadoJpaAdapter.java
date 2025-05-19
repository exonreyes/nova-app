package nova.empresa.adapter;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.empleado.Empleado;
import nova.empleado.EstatusEmpleado;
import nova.empresa.Puesto;
import nova.empresa.Unidad;
import nova.empresa.command.EmpleadoFiltroCommand;
import nova.empresa.model.view.EmpleadoGenerales;
import nova.empresa.port.EmpleadoPersistencePort;
import nova.empresa.repository.EmpleadoGeneralesJpaRepository;
import nova.empresa.specifications.EmpleadoSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EmpleadoJpaAdapter implements EmpleadoPersistencePort {
    private final EmpleadoGeneralesJpaRepository repository;

    private static Empleado apply(EmpleadoGenerales x) {
        Empleado empleado = new Empleado(x.getId(), x.getCodigoEmpleado(), x.getNombre(), x.getApellidoPaterno(), x.getApellidoMaterno());
        empleado.setEstatus(EstatusEmpleado.fromCodigo(x.getEstatus()));

        Unidad unidad = new Unidad(x.getIdUnidad(), x.getClaveUnidad(), x.getNombreUnidad());
        Puesto puesto = new Puesto(x.getIdPuesto(), x.getPuesto());
        empleado.setUnidad(unidad);
        empleado.setPuesto(puesto);
        return empleado;
    }

    @Override
    public Data<List<Empleado>> obtenerEmpleadosPorFiltro(EmpleadoFiltroCommand filtro) {
        Page<Empleado> page = repository.findAll(EmpleadoSpecifications.filtro(filtro), PageRequest.of(filtro.page(), filtro.size()))
                .map(EmpleadoJpaAdapter::apply);
        return Data.paginated(page.getContent(), page.getNumber(), page.getNumberOfElements(), page.getTotalElements(), page.getTotalPages());
    }

    @Override
    public Optional<Empleado> obtenerEmpleadoPorId(Integer id) {
        return repository.findById(id).map(EmpleadoJpaAdapter::apply);
    }

    @Override
    public Optional<Empleado> obtenerEmpleadoPorCodigo(String codigo) {
        return repository.findByCodigoEmpleado(codigo).map(EmpleadoJpaAdapter::apply);
    }
}
