package nova.localizacion.port;

import nova.commons.ubicacion.Estado;
import nova.commons.ubicacion.Zona;

import java.util.List;
import java.util.Optional;

public interface EstadoPersistencePort {
    List<Estado> obtenerEstados();

    List<Estado> obtenerEstadosConZonas();

    Optional<Estado> obtenerEstado(String clave);

    List<Zona> obtenerZonas();
}
