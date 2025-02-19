package nova.application.empleado;

import lombok.RequiredArgsConstructor;
import nova.domain.empleado.model.Empleado;
import nova.domain.empleado.port.EmpleadoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmpleadoHandler {
    private final EmpleadoDao dao;

    public List<Empleado> empleadosByPuestoAndEstatus(Integer idPuesto, Boolean estatus) {
        return dao.obtenerPorPuesto(idPuesto, estatus);
    }
}
