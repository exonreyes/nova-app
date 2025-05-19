package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.Proveedor;
import nova.cuenta.command.FiltroCuentaCmd;
import nova.cuenta.port.CredencialPersistencePort;
import nova.cuenta.port.ProveedorPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerCredenciales implements Executor<Proveedor, FiltroCuentaCmd> {
    private final ProveedorPersistencePort proveedorPort;
    private final CredencialPersistencePort credencialPort;

    @Override
    public Proveedor execute(FiltroCuentaCmd filtro) {
        Proveedor proveedor = proveedorPort.getProveedorById(filtro.getIdProveedor()).orElseThrow(() -> new IDNotFoundException("No se encontro el proveedor"));
        proveedor.setCredenciales(credencialPort.obtenerCredenciales(filtro));
        return proveedor;
    }
}
