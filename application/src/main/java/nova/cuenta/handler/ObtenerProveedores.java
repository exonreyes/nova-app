package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.Proveedor;
import nova.cuenta.port.ProveedorPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ObtenerProveedores implements Executor<List<Proveedor>, Void> {
    private final ProveedorPersistencePort port;

    @Override
    public List<Proveedor> execute(Void params) {
        return port.getProveedores();
    }
}
