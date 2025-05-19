package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Area;
import nova.empresa.command.AreaFiltro;

import nova.empresa.port.AreaPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional(readOnly = true)
public class ObtenerAreasPorFiltro implements Executor<List<Area>, AreaFiltro> {
    private final AreaPersistencePort port;

    @Override
    public List<Area> execute(AreaFiltro areaFiltro) {
        return port.obtenerAreas(areaFiltro);
    }
}
