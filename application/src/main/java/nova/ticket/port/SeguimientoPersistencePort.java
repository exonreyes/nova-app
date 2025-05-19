package nova.ticket.port;


import nova.ticket.Seguimiento;

import java.util.List;

public interface SeguimientoPersistencePort {
    List<Seguimiento> seguimientoByID(Integer folio);

    void guardar(Seguimiento seguimiento);
}
