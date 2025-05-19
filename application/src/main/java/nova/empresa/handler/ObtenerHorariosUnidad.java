package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.HorarioOperativo;
import nova.empresa.port.UnidadOperacionPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerHorariosUnidad implements Executor<List<HorarioOperativo>, Integer> {
    private final UnidadOperacionPersistencePort port;

    @Override
    public List<HorarioOperativo> execute(Integer id) {
        return port.obtenerHorarios(id);
    }
}
