package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Data;
import nova.commons.Executor;
import nova.empleado.Empleado;
import nova.empresa.command.EmpleadoFiltroCommand;
import nova.empresa.port.EmpleadoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerEmpleados implements Executor<Data<List<Empleado>>, EmpleadoFiltroCommand> {
    private final EmpleadoPersistencePort repository;

    @Override
    public Data<List<Empleado>> execute(EmpleadoFiltroCommand params) {
        return repository.obtenerEmpleadosPorFiltro(params);
    }
}
