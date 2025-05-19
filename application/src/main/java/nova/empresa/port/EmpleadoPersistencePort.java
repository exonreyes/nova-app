package nova.empresa.port;

import nova.commons.Data;
import nova.empleado.Empleado;
import nova.empresa.command.EmpleadoFiltroCommand;

import java.util.List;
import java.util.Optional;

public interface EmpleadoPersistencePort {
    Data<List<Empleado>> obtenerEmpleadosPorFiltro(EmpleadoFiltroCommand filtro);

    Optional<Empleado> obtenerEmpleadoPorId(Integer id);

    Optional<Empleado> obtenerEmpleadoPorCodigo(String id);
}
