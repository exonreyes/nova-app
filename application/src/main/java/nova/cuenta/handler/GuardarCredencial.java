package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.Credencial;
import nova.cuenta.port.CredencialPersistencePort;

@RequiredArgsConstructor
@UseCase
public class GuardarCredencial implements Executor<Void, Credencial> {
    private final CredencialPersistencePort credencialPort;


    @Override
    public Void execute(Credencial credencial) {
        credencialPort.guardar(credencial);
        return null;
    }
}