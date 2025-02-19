package nova.domain.empresa.port;

import nova.core.empresa.Puesto;

import java.util.List;

public interface PuestoDao {
    List<Puesto> obtenerPuestos();
}
