package nova.application.empresa;

import lombok.RequiredArgsConstructor;
import nova.core.empresa.Base;
import nova.domain.empresa.model.Unidad;
import nova.domain.empresa.port.UnidadNegocioDao;
import nova.domain.empresa.port.UnidadOperacionDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UnidadNegocioHandler {
    private final UnidadOperacionDao operacionesDao;
    private final UnidadNegocioDao dao;

    public List<Base> obtenerUnidadesNegocio(Integer IDEmpresa) {
        return dao.generalesByIdEmpresa(IDEmpresa);
    }

    public List<Base> obtenerUnidadesPorZona(Integer IDZona) {
        return dao.generalesByZona(IDZona);
    }

    public List<Base> obtenerUnidadesPorSupervisor(Long id) {
        return dao.generalesPorSupervisor(id);
    }

    public Unidad obtenerContacto(Integer id) {
        return dao.obtenerContacto(id);
    }

    public Unidad obtenerHorarios(Integer id) {
        return operacionesDao.getHorariosOperacion(id);
    }
}
