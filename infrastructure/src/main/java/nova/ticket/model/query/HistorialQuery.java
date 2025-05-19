package nova.ticket.model.query;

import java.io.Serializable;
import java.time.LocalDateTime;

public record HistorialQuery(Integer id, Integer estatusId, String estatusNombre, String agente, String descripcion,
                             LocalDateTime creado) implements Serializable {
}