package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Puesto;
import nova.empresa.port.PuestoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ObtenerPuestos implements Executor<List<Puesto>, Void> {
    private final PuestoPersistencePort port;

    @Override
    public List<Puesto> execute(Void params) {
        return port.obtenerPuestos();
    }
}
