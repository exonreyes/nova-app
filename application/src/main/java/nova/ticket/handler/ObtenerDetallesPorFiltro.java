package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.exception.IDNotFoundException;
import nova.ticket.Ticket;
import nova.ticket.TicketPersistencePort;
import nova.ticket.command.FiltroDetallesTicketCommand;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ObtenerDetallesPorFiltro implements Executor<Ticket, FiltroDetallesTicketCommand> {
    private final TicketPersistencePort port;

    @Override
    public Ticket execute(FiltroDetallesTicketCommand params) {
        if (params.id() == null) {
            return port.detallesPorFolio(params.folio()).orElseThrow(() -> new IDNotFoundException("No se encontró el folio " + params.folio() + " especificado del ticket"));
        } else {
            return port.detallesPorID(params.id()).orElseThrow(() -> new IDNotFoundException("No se encontró el ID" + params.id() + " especificado del ticket"));
        }
    }
}