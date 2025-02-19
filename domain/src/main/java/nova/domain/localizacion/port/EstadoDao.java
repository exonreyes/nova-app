package nova.domain.localizacion.port;

import nova.core.localizacion.Estado;
import nova.core.localizacion.Zona;

import java.util.List;

public interface EstadoDao {
    List<Estado> obtenerEstados();

    List<Estado> obtenerEstadosConZonas();

    Estado obtenerEstado(String clave);

    Estado obtenerZonas(String clave);

    List<Zona> obtenerZonas();
}
