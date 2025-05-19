package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Unidad;
import nova.empresa.port.UnidadPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerUnidadesPorZona implements Executor<List<Unidad>, Integer> {
    private final UnidadPersistencePort port;

    @Override
    public List<Unidad> execute(Integer params) {
        return port.obtenerGeneralesPorZona(params);
    }
}
