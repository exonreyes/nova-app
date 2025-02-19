package nova.application.actividad;

import lombok.RequiredArgsConstructor;
import nova.core.actividad.Estatus;
import nova.domain.actividad.port.EstatusDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EstatusSeguimientoHandler {
    private final EstatusDao estatusDao;

    public List<Estatus> obtenerEstatusSeguimiento() {
        return estatusDao.obtenerEstatus();
    }

    public List<Estatus> obtenerEstatusSeguimientoPorIds(List<Integer> list) {
        return estatusDao.obtenerPorIds(list);
    }
}