package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Departamento;
import nova.empresa.port.DepartamentoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional(readOnly = true)
public class ObtenerDepartamentos implements Executor<List<Departamento>, Void> {
    private final DepartamentoPersistencePort port;

    @Override
    public List<Departamento> execute(Void params) {
        return port.obtenerDepartamentos();
    }
}
