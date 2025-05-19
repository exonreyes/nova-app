package nova.ticket;
import nova.commons.Data;
import nova.ticket.command.FiltroGeneralesTicketCommand;
import java.util.List;
import java.util.Optional;

public interface TicketPersistencePort {
    Optional<Ticket> generalesPorFolio(String folio);

    Optional<Ticket> generalesPorID(Integer id);

    Optional<Ticket> detallesPorID(Integer id);

    Optional<Ticket> detallesPorFolio(String folio);

    boolean existeFolio(String folio);

    Ticket guardar(Ticket ticket);

    void actualizar(Ticket ticket);

    void actualizarEstado(Ticket ticket);

    Data<List<Ticket>> obtenerGenerales(FiltroGeneralesTicketCommand filtro);

    void actualizarEstatus(Integer idTicket, Integer idEstatus);

    void actualizarEstadoPublico(Ticket ticket);
}
