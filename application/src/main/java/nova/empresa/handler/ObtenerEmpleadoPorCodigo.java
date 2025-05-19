package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empleado.Empleado;
import nova.empresa.port.EmpleadoPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ObtenerEmpleadoPorCodigo implements Executor<Empleado, String> {
    private final EmpleadoPersistencePort port;

    @Override
    public Empleado execute(String params) {
        return port.obtenerEmpleadoPorCodigo(params).orElseThrow(() -> new IDNotFoundException("No se encontró número de empleado"));
    }
}
