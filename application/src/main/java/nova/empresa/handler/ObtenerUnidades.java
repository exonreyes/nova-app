package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Unidad;
import nova.empresa.port.UnidadPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@UseCase
public class ObtenerUnidades implements Executor<List<Unidad>, Void> {
    private final UnidadPersistencePort port;

    @Override
    public List<Unidad> execute(Void params) {
        return port.obtenerUnidades();
    }
}
