package nova.ticket.model.query;

import java.io.Serializable;
import java.time.LocalDateTime;


public record TicketInfoQuery(Integer id, Integer unidadId, String unidadClave, String unidadNombre, Integer estatusId,
                              String estatusNombre, Integer reporteId, String reporteNombre, Integer reporteAreaId,
                              String reporteAreaNombre, String folio, String agente,
                              LocalDateTime creado, Boolean publicar,
                              LocalDateTime actualizado) implements Serializable {
}