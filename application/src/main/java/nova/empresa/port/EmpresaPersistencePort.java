package nova.empresa.port;


import nova.empresa.Empresa;

import java.util.Optional;

public interface EmpresaPersistencePort {
    Optional<Empresa> obtenerEmpresa(Integer empresaId);

    Optional<Empresa> obtenerDetalles(Integer empresaId);
}
