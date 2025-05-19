package nova.ticket.command;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class FiltroGeneralesTicketCommand {
    private Integer unidadId;
    private Integer estatusId;
    private Integer areaId;
    private Integer pagina;
    private String orderBy;
    private Integer filas;
    private String folio;
    private Boolean publicar;
    private LocalDateTime creadoDesde;
    private LocalDateTime creadoHasta;
    private Integer supervisorId;
    private Integer zonaId;
}
