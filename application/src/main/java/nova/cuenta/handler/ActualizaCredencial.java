package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.Credencial;
import nova.cuenta.port.CredencialPersistencePort;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ActualizaCredencial implements Executor<Void, Credencial> {
    private final CredencialPersistencePort credencialPort;

    @Override
    public Void execute(Credencial params) {
        credencialPort.actualizar(params);
        return null;
    }
}
