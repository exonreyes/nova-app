package nova.infrastructure.empresa.persistence.adapter;

import lombok.RequiredArgsConstructor;
import nova.domain.actividad.model.HorarioOperativo;
import nova.domain.empresa.model.Unidad;
import nova.domain.empresa.port.UnidadOperacionDao;
import nova.infrastructure.empresa.persistence.exception.UnidadNotFoundException;
import nova.infrastructure.empresa.persistence.query.UnidadHorarioQuery;
import nova.infrastructure.empresa.persistence.repository.UnidadHorarioRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UnidadHorarioJpaAdapter implements UnidadOperacionDao {
    private final UnidadHorarioRepository repository;

    @Override
    public Unidad getHorariosOperacion(Integer idUnidad) {
        var data = repository.findByUnidadId(idUnidad, UnidadHorarioQuery.class);
        if (data.isEmpty()) {
            throw new UnidadNotFoundException("No se encontró la unidadd especificada con el ID " + idUnidad);
        }
        Unidad unidad = new Unidad(idUnidad);
        unidad.setHorarios(data.stream().map(x -> new HorarioOperativo(x.id(), x.operatividadId(), x.operatividadNombre(), x.apertura(), x.cierre())).toList());
        return unidad;
    }
}
