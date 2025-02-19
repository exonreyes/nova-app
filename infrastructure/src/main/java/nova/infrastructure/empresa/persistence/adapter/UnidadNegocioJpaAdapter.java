package nova.infrastructure.empresa.persistence.adapter;
import lombok.RequiredArgsConstructor;
import nova.core.empresa.Base;
import nova.core.localizacion.Contacto;
import nova.core.localizacion.Estado;
import nova.core.localizacion.Zona;
import nova.core.persona.Persona;
import nova.domain.empresa.model.Unidad;
import nova.domain.empresa.port.UnidadNegocioDao;
import nova.infrastructure.empresa.persistence.exception.UnidadNotFoundException;
import nova.infrastructure.empresa.persistence.query.UnidadContactoQuery;
import nova.infrastructure.empresa.persistence.query.UnidadNegocioQuery;
import nova.infrastructure.empresa.persistence.repository.UnidadNegocioRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UnidadNegocioJpaAdapter implements UnidadNegocioDao {
    private final UnidadNegocioRepository repository;

    @Override
    public List<Base> generalesByIdEmpresa(Integer IDEmpresa) {
        return repository.findByEmpresaId(IDEmpresa, UnidadNegocioQuery.class)
                .stream()
                .map(x -> new Base(x.id(), x.clave(), x.nombre()))
                .toList();
    }

    @Override
    public List<Base> generalesByZona(Integer IDZona) {
        return repository.findByZonaId(IDZona, UnidadNegocioQuery.class)
                .stream()
                .map(x -> new Base(x.id(), x.clave(), x.nombre()))
                .toList();
    }

    @Override
    public List<Base> generalesPorSupervisor(Long id) {
        return repository.findBySupervisorId(id, UnidadNegocioQuery.class)
                .stream()
                .map(x -> new Base(x.id(), x.clave(), x.nombre()))
                .toList();
    }

    @Override
    public Unidad obtenerContacto(Integer id) {
        return repository.findById(id, UnidadContactoQuery.class).
                map(x -> {
                    Unidad unidad = new Unidad(x.id(), x.clave(), x.nombre());
                    unidad.setNivelOperativo(x.nivel());
                    unidad.setOperativo(x.operativo());
                    unidad.setActualizado(x.ultimaActualizacion());
                    unidad.setSupervisor(new Persona(x.supervisorPersonaNombre()));
                    unidad.setContacto(new Contacto(x.telefono(), x.direccion(), new Zona(x.zonaNombre(), new Estado(x.zonaEstadoNombre()))));
                    return unidad;
                })
                .orElseThrow(() -> new UnidadNotFoundException("No se encontró la unidad de negocio"));
    }
}
