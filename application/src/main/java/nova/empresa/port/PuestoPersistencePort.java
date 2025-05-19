package nova.empresa.port;

import nova.empresa.Puesto;

import java.util.List;

public interface PuestoPersistencePort {
    List<Puesto> obtenerPuestos();
}
