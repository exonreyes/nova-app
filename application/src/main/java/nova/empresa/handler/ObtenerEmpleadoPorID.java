package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empleado.Empleado;
import nova.empresa.port.EmpleadoPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerEmpleadoPorID implements Executor<Empleado, Integer> {
    private final EmpleadoPersistencePort port;

    @Override
    public Empleado execute(Integer params) {
        return port.obtenerEmpleadoPorId(params).orElseThrow(() -> new IDNotFoundException("No se encontró el empleado con el ID: " + params));
    }
}
