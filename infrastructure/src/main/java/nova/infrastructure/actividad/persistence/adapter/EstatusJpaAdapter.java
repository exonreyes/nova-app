package nova.infrastructure.actividad.persistence.adapter;

import lombok.RequiredArgsConstructor;
import nova.core.actividad.Estatus;
import nova.domain.actividad.port.EstatusDao;
import nova.infrastructure.actividad.persistence.repository.EstatusSeguimientoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EstatusJpaAdapter implements EstatusDao {
    private final EstatusSeguimientoRepository estatusRepository;

    @Override
    public List<Estatus> obtenerEstatus() {
        return estatusRepository.findAll().stream().map(estatus -> new Estatus(estatus.getId(), estatus.getNombre())).toList();
    }

    @Override
    public List<Estatus> obtenerPorIds(List<Integer> list) {
        return estatusRepository.findAllById(list).stream().map(estatus -> new Estatus(estatus.getId(), estatus.getNombre())).toList();
    }
}
