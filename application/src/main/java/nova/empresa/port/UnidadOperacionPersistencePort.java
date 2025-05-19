package nova.empresa.port;

import nova.empresa.HorarioOperativo;

import java.util.List;

public interface UnidadOperacionPersistencePort {
    List<HorarioOperativo> obtenerHorarios(Integer idUnidad);
}
