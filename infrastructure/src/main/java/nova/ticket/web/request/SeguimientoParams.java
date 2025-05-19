package nova.ticket.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import nova.commons.Estatus;
import nova.ticket.command.SeguimientoCommand;

import java.time.LocalDateTime;

@Getter
public class SeguimientoParams {
    private String agente;
    @NotNull
    private Integer idEstatus;
    private String descripcion;
    @NotNull
    @Min(value = 1)
    private Integer idTicket;

    public SeguimientoCommand toCommand() {
        return new SeguimientoCommand(idTicket, new Estatus(idEstatus), descripcion, LocalDateTime.now(), agente);
    }
}