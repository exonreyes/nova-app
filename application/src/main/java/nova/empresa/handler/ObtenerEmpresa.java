package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Empresa;
import nova.empresa.port.EmpresaPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@UseCase
public class ObtenerEmpresa implements Executor<Empresa, Integer> {
    private final EmpresaPersistencePort repository;

    @Override
    public Empresa execute(Integer id) {
        return repository.obtenerEmpresa(id).orElseThrow(() -> new IDNotFoundException("Empresa con ID " + id + " no encontrada"));
    }
}
