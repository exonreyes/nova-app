package nova.ticket.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record FiltroTicketRequest(
        Integer id,
        Integer unidadId,
        Integer estatusId,
        Integer areaId,
        Boolean publicar,
        Integer pagina,
        @Min(value = 1)
        Integer filas,
        String folio,
        @PastOrPresent
        LocalDateTime desde,
        LocalDateTime hasta,
        Integer supervisorId,
        Integer zonaId
) {
}