package nova.domain.actividad.port;

import nova.core.actividad.Estatus;

import java.util.List;

public interface EstatusDao {
    List<Estatus> obtenerEstatus();

    List<Estatus> obtenerPorIds(List<Integer> ids);
}
