package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.area.Reporte;
import nova.commons.Estatus;
import nova.commons.Executor;
import nova.empresa.Unidad;
import nova.exception.IDNotFoundException;
import nova.ticket.Seguimiento;
import nova.ticket.Ticket;
import nova.ticket.TicketPersistencePort;
import nova.ticket.command.CrearTicketCommand;
import nova.ticket.port.SeguimientoPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@UseCase
@RequiredArgsConstructor
@Transactional
public class GuardarTicket implements Executor<Ticket, CrearTicketCommand> {
    private final TicketPersistencePort ticketRepository;
    private final SeguimientoPersistencePort seguimientoRepository;

    @Override
    public Ticket execute(CrearTicketCommand params) {
        Ticket ticket = new Ticket(new Unidad(params.idUnidad()), new Reporte(params.idReporte()));
        ticket.setDescripcion(params.descripcion());
        ticket.setEstatus(new Estatus(params.idEstatus()));
        ticket.setAgente(params.agente());
        ticket.setFolio(params.folio());
        ticket.setPublicar(params.publicar());
        Ticket temp = ticketRepository.guardar(ticket);
        temp.setDescripcion("Folio registrado");
        seguimientoRepository.guardar(new Seguimiento(temp.getId(), ticket.getAgente(), ticket.getEstatus(), "El evento ha sido registrado", LocalDateTime.now()));
        return ticketRepository.generalesPorID(temp.getId()).orElseThrow(() -> new IDNotFoundException("No se encontraron resultados para el ticket asociado al registro"));
    }

}
