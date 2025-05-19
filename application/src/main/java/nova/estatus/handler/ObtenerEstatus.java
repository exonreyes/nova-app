package nova.estatus.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Estatus;
import nova.commons.Executor;
import nova.estatus.port.EstatusPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ObtenerEstatus implements Executor<List<Estatus>, Void> {
    private final EstatusPersistencePort repository;

    @Override
    public List<Estatus> execute(Void params) {
        return repository.obtenerEstatus();
    }
}
