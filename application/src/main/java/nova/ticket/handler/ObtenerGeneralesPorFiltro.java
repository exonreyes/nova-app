package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Data;
import nova.commons.Executor;
import nova.ticket.Ticket;
import nova.ticket.TicketPersistencePort;
import nova.ticket.command.FiltroGeneralesTicketCommand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ObtenerGeneralesPorFiltro implements Executor<Data<List<Ticket>>, FiltroGeneralesTicketCommand> {
    private final TicketPersistencePort port;

    @Override
    public Data<List<Ticket>> execute(FiltroGeneralesTicketCommand params) {
        return port.obtenerGenerales(params);
    }
}
