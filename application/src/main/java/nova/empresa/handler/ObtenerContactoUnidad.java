package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Unidad;
import nova.empresa.port.UnidadPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerContactoUnidad implements Executor<Unidad, Integer> {
    private final UnidadPersistencePort port;

    @Override
    public Unidad execute(Integer params) {
        return port.obtenerContacto(params).orElseThrow(() -> new IDNotFoundException("No se encontró la unidad especificada por el ID " + params));
    }
}
