package nova.application.localizacion;

import lombok.RequiredArgsConstructor;
import nova.core.localizacion.Estado;
import nova.core.localizacion.Zona;
import nova.domain.localizacion.port.EstadoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EstadoHandler {
    private final EstadoDao dao;

    public List<Estado> obtenerEntidadesFederativas(Boolean agregarZonas) {
        if (agregarZonas) {
            return dao.obtenerEstadosConZonas();
        }
        return dao.obtenerEstados();
    }

    public Estado obtenerEntidadFederativa(String clave, Boolean agregarZonas) {
        if (agregarZonas) {
            return dao.obtenerZonas(clave);
        }
        return dao.obtenerEstado(clave);
    }

    public List<Zona> obtenerZonas() {
        return dao.obtenerZonas();
    }
}