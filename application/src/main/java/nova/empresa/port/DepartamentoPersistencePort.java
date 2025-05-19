package nova.empresa.port;

import nova.empresa.Departamento;

import java.util.List;

public interface DepartamentoPersistencePort {
    List<Departamento> obtenerDepartamentos();
}