package nova.ticket.adapter;

import lombok.RequiredArgsConstructor;
import nova.commons.Estatus;
import nova.estatus.model.EstatusModel;
import nova.ticket.Seguimiento;
import nova.ticket.model.HistorialTicketModel;
import nova.ticket.model.query.HistorialQuery;
import nova.ticket.port.SeguimientoPersistencePort;
import nova.ticket.repository.HistorialJpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeguimientoJpaAdapter implements SeguimientoPersistencePort {
    private final HistorialJpaRepository repository;

    @Override
    public List<Seguimiento> seguimientoByID(Integer id) {
        return repository.findByIdTicket(id, HistorialQuery.class, Sort.by("creado").descending()).stream()
                .map(x -> new Seguimiento(x.id(), x.agente(), new Estatus(x.estatusId(), x.estatusNombre()), x.descripcion(), x.creado())).toList();
    }

    @Override
    public void guardar(Seguimiento seguimiento) {
        var temp = new HistorialTicketModel();
        temp.setIdTicket(seguimiento.getId());
        temp.setAgente(seguimiento.getAgente());
        temp.setDescripcion(seguimiento.getDescripcion());
        temp.setCreado(seguimiento.getCreado());
        temp.setEstatus(new EstatusModel(seguimiento.getEstatus().getId()));
        repository.save(temp);
    }
}
