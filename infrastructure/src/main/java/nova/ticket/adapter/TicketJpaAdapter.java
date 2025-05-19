package nova.ticket.adapter;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.empresa.model.ReporteAreaModel;
import nova.empresa.model.UnidadModel;
import nova.estatus.model.EstatusModel;
import nova.ticket.Ticket;
import nova.ticket.TicketPersistencePort;
import nova.ticket.command.FiltroGeneralesTicketCommand;
import nova.ticket.exception.FolioDuplicadoException;
import nova.ticket.exception.TicketSaveException;
import nova.ticket.mapper.TicketMapper;
import nova.ticket.model.TicketModel;
import nova.ticket.model.query.TicketDetallesQuery;
import nova.ticket.model.query.TicketInfoQuery;
import nova.ticket.repository.TicketFiltroJpaRepository;
import nova.ticket.repository.TicketJpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TicketJpaAdapter implements TicketPersistencePort {

    private final TicketJpaRepository repository;
    private final TicketFiltroJpaRepository filtroRepository;

    @Override
    public Optional<Ticket> generalesPorFolio(String folio) {
        return repository.findByFolio(folio, TicketInfoQuery.class)
                .map(TicketMapper::convertirGenerales);
    }

    @Override
    public Optional<Ticket> generalesPorID(Integer id) {
        return repository.findById(id, TicketInfoQuery.class)
                .map(TicketMapper::convertirGenerales);
    }

    @Override
    public Optional<Ticket> detallesPorID(Integer id) {
        return repository.findById(id, TicketDetallesQuery.class)
                .map(TicketMapper::convertirDetalles);
    }

    @Override
    public Optional<Ticket> detallesPorFolio(String folio) {
        return repository.findByFolio(folio, TicketDetallesQuery.class)
                .map(TicketMapper::convertirDetalles);
    }

    @Override
    public boolean existeFolio(String folio) {
        return repository.existsByFolio(folio);
    }

    @Override
    public Ticket guardar(Ticket ticket) {
        try {
            TicketModel model = mapToTicketModel(ticket);
            var result = repository.save(model);
            ticket.setId(result.getId());
            return ticket;
        } catch (DataAccessException e) {
            handlePersistenceException(e, "No se pudo guardar el ticket");
            return null; // Unreachable, pero requerido por compilador
        }
    }

    @Override
    public void actualizar(Ticket ticket) {
        try {
            TicketModel model = mapToTicketModel(ticket);
            repository.save(model);
        } catch (DataAccessException e) {
            handlePersistenceException(e, "No se pudo actualizar el ticket");
        }
    }

    @Override
    public Data<List<Ticket>> obtenerGenerales(FiltroGeneralesTicketCommand filtro) {
        return filtroRepository.obtenerGenerales(filtro);
    }

    @Override
    public void actualizarEstado(Ticket ticket) {
        throw new UnsupportedOperationException("Método actualizarEstado no implementado aún");
    }

    @Override
    public void actualizarEstatus(Integer idTicket, Integer idEstatus) {
        throw new UnsupportedOperationException("Método actualizarEstatus no implementado aún");
    }

    @Override
    public void actualizarEstadoPublico(Ticket ticket) {
        throw new UnsupportedOperationException("Método actualizarEstadoPublico no implementado aún");
    }

    // --------------------- MÉTODOS PRIVADOS ---------------------

    private TicketModel mapToTicketModel(Ticket ticket) {
        TicketModel model = new TicketModel(ticket.getId());
        model.setFolio(ticket.getFolio());
        model.setEstatus(new EstatusModel(ticket.getEstatus().getId()));
        model.setReporte(new ReporteAreaModel(ticket.getTitulo().getId()));
        model.setUnidad(new UnidadModel(ticket.getUnidad().getId()));
        model.setAgente(ticket.getAgente());
        model.setCreado(ticket.getCreado());
        model.setPublicar(ticket.getPublicar());
        model.setDescripcion(ticket.getDescripcion());
        model.setActualizado(ticket.getActualizado());
        return model;
    }

    private void handlePersistenceException(DataAccessException e, String mensaje) {
        if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
            throw new FolioDuplicadoException("El folio ya existe. No se pudo procesar el ticket.");
        }
        throw new TicketSaveException(mensaje, e.getCause());
    }
}
