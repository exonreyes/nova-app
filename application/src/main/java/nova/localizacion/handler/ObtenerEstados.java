package nova.localizacion.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.commons.ubicacion.Estado;
import nova.localizacion.port.EstadoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@UseCase
@RequiredArgsConstructor
public class ObtenerEstados implements Executor<List<Estado>, Boolean> {
    private final EstadoPersistencePort estadoPersistencePort;

    @Override
    public List<Estado> execute(Boolean params) {
        return params ? estadoPersistencePort.obtenerEstadosConZonas() : estadoPersistencePort.obtenerEstados();
    }
}
