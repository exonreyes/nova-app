package nova.domain.empresa.port;


import nova.core.empresa.Empresa;

public interface EmpresaDao {
    Empresa obtenerEmpresa(Integer empresaId);

    Empresa obtenerDetalles(Integer empresaId);
}
