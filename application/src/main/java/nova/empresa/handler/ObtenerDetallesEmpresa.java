package nova.empresa.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.empresa.Empresa;
import nova.empresa.port.EmpresaPersistencePort;
import nova.exception.IDNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ObtenerDetallesEmpresa implements Executor<Empresa, Integer> {
    private final EmpresaPersistencePort dao;

    @Override
    public Empresa execute(Integer id) {
        return dao.obtenerDetalles(id).orElseThrow(() -> new IDNotFoundException("Empresa con ID " + id + " no encontrada"));
    }
}
