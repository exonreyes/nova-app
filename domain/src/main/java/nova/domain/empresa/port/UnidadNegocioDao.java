package nova.domain.empresa.port;

import nova.core.empresa.Base;
import nova.domain.empresa.model.Unidad;

import java.util.List;

public interface UnidadNegocioDao {
    List<Base> generalesByIdEmpresa(Integer IDEmpresa);

    List<Base> generalesByZona(Integer IDZona);

    List<Base> generalesPorSupervisor(Long id);

    Unidad obtenerContacto(Integer id);
}
