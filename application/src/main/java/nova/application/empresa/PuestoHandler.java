package nova.application.empresa;

import lombok.RequiredArgsConstructor;
import nova.core.empresa.Puesto;
import nova.domain.empresa.port.PuestoDao;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PuestoHandler {
    private final PuestoDao puestoDao;

    public List<Puesto> obtenerPuestos() {
        return puestoDao.obtenerPuestos();
    }
}
