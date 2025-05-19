package nova.estatus.port;

import nova.commons.Estatus;

import java.util.List;

public interface EstatusPersistencePort {
    List<Estatus> obtenerEstatus();

    List<Estatus> obtenerPorIds(List<Integer> ids);
}
