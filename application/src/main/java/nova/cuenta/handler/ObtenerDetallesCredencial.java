package nova.cuenta.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.cuenta.Credencial;
import nova.cuenta.port.CredencialPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ObtenerDetallesCredencial implements Executor<Credencial, Integer> {
    private final CredencialPersistencePort repository;

    @Override
    public Credencial execute(Integer idCredencial) {
        return repository.obtenerDetalles(idCredencial).orElseThrow(() -> new IDNotFoundException("No se encontró la credencial especificada por el ID " + idCredencial));
    }
}
