package nova.empresa.port;

import nova.empresa.Area;
import nova.empresa.command.AreaFiltro;


import java.util.List;

public interface AreaPersistencePort {
    List<Area> obtenerAreas(AreaFiltro filtro);
}
