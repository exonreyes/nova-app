package nova.empresa.port;


import nova.empresa.Unidad;

import java.util.List;
import java.util.Optional;

public interface UnidadPersistencePort {
    List<Unidad> obtenerUnidades();

    List<Unidad> obtenerGeneralesPorSupervisor(Integer idSupervisor);

    List<Unidad> obtenerGeneralesPorZona(Integer idZona);

    Optional<Unidad> obtenerContacto(Integer id);

    Boolean existeUnidad(Integer id);
}
