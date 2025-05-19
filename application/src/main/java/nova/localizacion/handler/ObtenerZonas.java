package nova.localizacion.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.commons.ubicacion.Zona;
import nova.localizacion.port.EstadoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional(readOnly = true)
public class ObtenerZonas implements Executor<List<Zona>, Void> {
    private final EstadoPersistencePort repository;

    @Override
    public List<Zona> execute(Void params) {
        return repository.obtenerZonas();
    }
}
