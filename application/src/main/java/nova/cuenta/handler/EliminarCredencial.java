package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.port.CredencialPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class EliminarCredencial implements Executor<Void, Integer> {
    private final CredencialPersistencePort port;

    @Override
    public Void execute(Integer params) {
        if (port.existePorID(params)) {
            port.eliminar(params);
            return null;
        } else {
            throw new IDNotFoundException("No se pudo eliminar la credencial, el registro no existe");
        }
    }
}
