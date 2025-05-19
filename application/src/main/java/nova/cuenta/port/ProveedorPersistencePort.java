package nova.cuenta.port;

import nova.cuenta.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorPersistencePort {
    List<Proveedor> getProveedores();

    Optional<Proveedor> getProveedorById(Integer id);
}
