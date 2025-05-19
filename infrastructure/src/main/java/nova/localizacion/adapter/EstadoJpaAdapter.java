package nova.localizacion.adapter;

import lombok.RequiredArgsConstructor;
import nova.commons.ubicacion.Estado;
import nova.commons.ubicacion.Zona;
import nova.cuenta.model.query.localizacion.ZonaQuery;
import nova.localizacion.port.EstadoPersistencePort;
import nova.localizacion.repository.EstadoJpaRepository;
import nova.localizacion.repository.ZonaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EstadoJpaAdapter implements EstadoPersistencePort {
    private final EstadoJpaRepository estadoRepositorio;
    private final ZonaJpaRepository zonaRepositorio;

    @Override
    public List<Estado> obtenerEstados() {
        return estadoRepositorio.findAll()
                .stream().map(x -> new Estado(x.getId(), x.getCodigo(), x.getNombre()))
                .toList();
    }

    @Override
    public List<Estado> obtenerEstadosConZonas() {
        return estadoRepositorio.obtenerEstadosConZonas()
                .stream()
                .map(x -> new Estado(x.getId(),
                        x.getCodigo(),
                        x.getNombre(),
                        x.getZonas().stream().map(y ->
                                        new Zona(y.getId(), y.getNombre()))
                                .toList()))
                .toList();
    }

    @Override
    public Optional<Estado> obtenerEstado(String clave) {
        return estadoRepositorio.findById(clave).map(x -> new Estado(x.getId(), x.getCodigo(), x.getNombre()));
    }

    @Override
    public List<Zona> obtenerZonas() {
        return zonaRepositorio.findBy(ZonaQuery.class).stream().map(x -> new Zona(x.id(), x.nombre(), x.estadoId())).toList();
    }
}