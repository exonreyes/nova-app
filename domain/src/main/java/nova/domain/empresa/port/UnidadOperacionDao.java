package nova.domain.empresa.port;

import nova.domain.empresa.model.Unidad;

public interface UnidadOperacionDao {
    Unidad getHorariosOperacion(Integer idUnidad);
}
