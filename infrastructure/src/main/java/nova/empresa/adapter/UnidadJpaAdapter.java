package nova.empresa.adapter;

import lombok.RequiredArgsConstructor;
import nova.commons.ubicacion.Contacto;
import nova.commons.ubicacion.Estado;
import nova.commons.ubicacion.Zona;
import nova.empleado.Empleado;
import nova.empresa.Unidad;
import nova.empresa.model.query.GeneralesUnidadQuery;
import nova.empresa.model.query.UnidadContactoQuery;
import nova.empresa.port.UnidadPersistencePort;
import nova.empresa.repository.UnidadJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UnidadJpaAdapter implements UnidadPersistencePort {
    private final UnidadJpaRepository repository;

    @Override
    public List<Unidad> obtenerUnidades() {
        return repository.findBy(GeneralesUnidadQuery.class).stream().map(value -> new Unidad(value.id(), value.clave(), value.nombre(), value.segmento())).toList();
    }

    @Override
    public List<Unidad> obtenerGeneralesPorSupervisor(Integer idSupervisor) {
        return repository.findBySupervisor_Id(idSupervisor, GeneralesUnidadQuery.class)
                .stream().map(x ->
                        new Unidad(x.id(), x.clave(), x.nombre(), x.segmento())).toList();
    }

    @Override
    public List<Unidad> obtenerGeneralesPorZona(Integer idZona) {
        return repository.findByZona_Id(idZona, GeneralesUnidadQuery.class).stream().map(x -> new Unidad(x.id(), x.clave(), x.nombre(), x.segmento())).toList();
    }

    @Override
    public Optional<Unidad> obtenerContacto(Integer id) {
        return repository.findById(id, UnidadContactoQuery.class).map(x -> {
            Unidad unidad = new Unidad(x.id(), x.clave(), x.nombre(), x.segmento());
            unidad.setNivel(x.nivel());
            unidad.setOperativo(x.operativo());

            unidad.setSupervisor(new Empleado(x.supervisorId(), x.supervisorCodigo(), x.supervisorNombre(), x.supervisorApellidoPaterno(), x.supervisorApellidoMaterno()));
            Estado estado = new Estado(x.zonaEstadoId(), x.zonaEstadoCodigo(), x.zonaEstadoNombre());
            Zona zona = new Zona(x.zonaId(), x.zonaNombre(), estado);
            unidad.setContacto(new Contacto(x.telefono(), x.direccion(), zona));
            return unidad;
        });
    }

    @Override
    public Boolean existeUnidad(Integer id) {
        return repository.existsById(id);
    }
}
