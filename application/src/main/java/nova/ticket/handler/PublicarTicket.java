package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.ticket.Ticket;
import nova.ticket.TicketPersistencePort;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PublicarTicket implements Executor<Boolean, Ticket> {
    private final TicketPersistencePort ticketRepository;

    @Override
    public Boolean execute(Ticket params) {
        ticketRepository.actualizarEstado(params);
        return true;
    }
}
