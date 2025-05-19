package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.ticket.TicketPersistencePort;
import nova.ticket.command.SeguimientoCommand;
import nova.ticket.port.SeguimientoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GuardarSeguimiento implements Executor<Void, SeguimientoCommand> {
    private final SeguimientoPersistencePort port;
    private final TicketPersistencePort ticketRepository;

    @Override
    public Void execute(SeguimientoCommand params) {
        port.guardar(params.registrarCommand());
        ticketRepository.actualizarEstatus(params.getIdTicket(), params.getEstatus().getId());
        return null;
    }
}
