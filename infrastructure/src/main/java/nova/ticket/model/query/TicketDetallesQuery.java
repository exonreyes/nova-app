package nova.ticket.model.query;

import java.io.Serializable;
import java.time.LocalDateTime;

public record TicketDetallesQuery(Integer id, Integer unidadId, String unidadClave, String unidadNombre,
                                  Integer estatusId,
                                  String estatusNombre, Integer reporteId, Integer reporteAreaId,
                                  String reporteAreaNombre,
                                  Boolean reporteAreaExterno, String reporteNombre, String folio, String agente,
                                  String descripcion, Boolean publicar, LocalDateTime creado,
                                  LocalDateTime actualizado) implements Serializable {
}