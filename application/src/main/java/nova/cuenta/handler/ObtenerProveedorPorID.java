package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.Proveedor;
import nova.cuenta.port.ProveedorPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerProveedorPorID implements Executor<Proveedor, Integer> {
    private final ProveedorPersistencePort port;

    @Override
    public Proveedor execute(Integer params) {
        return port.getProveedorById(params).orElseThrow(() -> new IDNotFoundException("Proveedor no encontrado"));
    }
}
