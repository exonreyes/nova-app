package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.exception.IDNotFoundException;
import nova.ticket.Ticket;
import nova.ticket.TicketPersistencePort;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ActualizarTicket implements Executor<Boolean, Ticket> {
    private final TicketPersistencePort ticketRepository;

    @Override
    public Boolean execute(Ticket params) {
        if (params.getId() == null) {
            throw new IDNotFoundException("No se puede actualizar el ticket, ID no especificado");
        }
        ticketRepository.actualizar(params);
        return true;
    }
}
