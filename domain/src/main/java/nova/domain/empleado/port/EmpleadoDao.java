package nova.domain.empleado.port;

import nova.domain.empleado.model.Empleado;

import java.util.List;

public interface EmpleadoDao {
    List<Empleado> obtenerPorPuesto(Integer IDPuesto, Boolean estatus);
}
