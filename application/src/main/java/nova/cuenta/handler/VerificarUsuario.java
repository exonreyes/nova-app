package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.command.UsuarioEstatusCommand;
import nova.cuenta.port.CredencialPersistencePort;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VerificarUsuario implements Executor<Boolean, UsuarioEstatusCommand> {
    private final CredencialPersistencePort credencialPort;

    @Override
    public Boolean execute(UsuarioEstatusCommand params) {
        return credencialPort.existeUsuario(params.getIdProveedor(), params.getUsuario());
    }
}
