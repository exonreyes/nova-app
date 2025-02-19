package nova.infrastructure.localizacion.persistence.adapter;

import lombok.RequiredArgsConstructor;
import nova.core.localizacion.Estado;
import nova.core.localizacion.Zona;
import nova.domain.localizacion.port.EstadoDao;
import nova.infrastructure.localizacion.persistence.exception.EstadoNotFoundException;
import nova.infrastructure.localizacion.persistence.query.ZonaQuery;
import nova.infrastructure.localizacion.persistence.repository.EntidadFederativaRepository;
import nova.infrastructure.localizacion.persistence.repository.ZonaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
@Transactional(readOnly = true)
public class EstadoJpaAdapter implements EstadoDao {
    private final EntidadFederativaRepository estadoRepositorio;
    private final ZonaRepository zonaRepositorio;

    @Override
    public List<Estado> obtenerEstados() {
        return estadoRepositorio.findAll()
                .stream().map(x -> new Estado(x.getClave(), x.getNombre()))
                .toList();
    }

    @Override
    public List<Estado> obtenerEstadosConZonas() {
        return estadoRepositorio.obtenerConZonas()
                .stream().map(x -> new Estado(x.getClave(), x.getNombre(), x.getZonaFederativas().stream()
                        .map(y -> new Zona(y.getId(), y.getNombre())).toList()))
                .toList();
    }

    @Override
    public Estado obtenerEstado(String clave) {
        return estadoRepositorio.findById(clave)
                .map(x -> new Estado(x.getClave(), x.getNombre()))
                .orElseThrow(() -> new EstadoNotFoundException("Entidad federativa con ID " + clave + " no encontrada"));
    }

    @Override
    public Estado obtenerZonas(String clave) {
        return estadoRepositorio.obtenerZonas(clave).map(x -> new Estado(
                        x.getClave(),
                        x.getNombre(),
                        x.getZonaFederativas().stream()
                                .map(y -> new Zona(y.getId(), y.getNombre()))
                                .toList()))
                .orElseThrow(() -> new EstadoNotFoundException("Entidad federativa con ID " + clave + " no encontrada"));
    }

    @Override
    public List<Zona> obtenerZonas() {
        return zonaRepositorio.findBy(ZonaQuery.class).stream().map(x -> new Zona(x.id(), x.nombre(), x.estadoClave())).toList();
    }

}