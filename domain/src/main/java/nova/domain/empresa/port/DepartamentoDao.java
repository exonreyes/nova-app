package nova.domain.empresa.port;

import nova.core.empresa.Departamento;

import java.util.List;

public interface DepartamentoDao {
    List<Departamento> obtenerPorEmpresa(Integer empresaID);
}
