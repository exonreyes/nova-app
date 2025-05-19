package nova.ticket.repository;

import nova.commons.Data;
import nova.ticket.Ticket;
import nova.ticket.command.FiltroGeneralesTicketCommand;

import java.util.List;

public interface TicketFiltroJpaRepository {
    Data<List<Ticket>> obtenerGenerales(FiltroGeneralesTicketCommand filtro);
}
