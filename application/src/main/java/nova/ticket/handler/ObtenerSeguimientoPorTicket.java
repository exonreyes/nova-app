package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.ticket.Seguimiento;
import nova.ticket.port.SeguimientoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@UseCase
public class ObtenerSeguimientoPorTicket implements Executor<List<Seguimiento>, Integer> {
    private final SeguimientoPersistencePort port;

    @Override
    public List<Seguimiento> execute(Integer params) {
        return port.seguimientoByID(params);
    }
}
