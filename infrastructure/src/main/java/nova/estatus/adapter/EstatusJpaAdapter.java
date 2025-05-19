package nova.estatus.adapter;

import lombok.RequiredArgsConstructor;
import nova.commons.Estatus;
import nova.estatus.port.EstatusPersistencePort;
import nova.estatus.repository.EstatusJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EstatusJpaAdapter implements EstatusPersistencePort {
    private final EstatusJpaRepository estatusRepository;

    @Override
    public List<Estatus> obtenerEstatus() {
        return estatusRepository.findAll().stream().map(estatus -> new Estatus(estatus.getId(), estatus.getNombre())).toList();
    }

    @Override
    public List<Estatus> obtenerPorIds(List<Integer> list) {
        return estatusRepository.findAllById(list).stream().map(estatus -> new Estatus(estatus.getId(), estatus.getNombre())).toList();
    }
}
