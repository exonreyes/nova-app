package nova.ticket;

import nova.commons.Estatus;

import java.time.LocalDateTime;

public class Seguimiento extends Ticket {
    public Seguimiento(Integer id, String agente, Estatus estatus, String descripcion, LocalDateTime creado) {
        super(id, agente, estatus, descripcion, creado);
    }
}
