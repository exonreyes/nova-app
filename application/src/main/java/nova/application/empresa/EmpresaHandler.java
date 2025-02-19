package nova.application.empresa;

import lombok.RequiredArgsConstructor;
import nova.core.empresa.Departamento;
import nova.core.empresa.Empresa;
import nova.domain.empresa.port.DepartamentoDao;
import nova.domain.empresa.port.EmpresaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmpresaHandler {
    private final EmpresaDao dao;
    private final DepartamentoDao departamentoDao;

    public Empresa obtenerEmpresa(Integer id) {
        return dao.obtenerEmpresa(id);
    }

    public Empresa obtenerDetalles(Integer id) {
        return dao.obtenerDetalles(id);
    }

    public List<Departamento> obtenerDepartamentos(Integer id) {
        return departamentoDao.obtenerPorEmpresa(id);
    }
}
