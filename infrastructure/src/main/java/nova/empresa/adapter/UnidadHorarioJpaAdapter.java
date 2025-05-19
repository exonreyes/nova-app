package nova.empresa.adapter;

import lombok.RequiredArgsConstructor;
import nova.empresa.HorarioOperativo;
import nova.empresa.model.query.UnidadHorarioQuery;
import nova.empresa.port.UnidadOperacionPersistencePort;
import nova.empresa.repository.UnidadHorarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UnidadHorarioJpaAdapter implements UnidadOperacionPersistencePort {
    private final UnidadHorarioJpaRepository repository;

    @Override
    public List<HorarioOperativo> obtenerHorarios(Integer idUnidad) {
        return repository.findByUnidadId(idUnidad, UnidadHorarioQuery.class).stream().map(x -> new HorarioOperativo(x.id(), x.operatividadId(), x.operatividadNombre(), x.apertura(), x.cierre())).toList();
    }
}
