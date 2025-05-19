package nova.ticket.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.commons.Estatus;
import nova.ticket.Seguimiento;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class SeguimientoCommand {
    private Integer idTicket;
    private Estatus estatus;
    private String comentario;
    private LocalDateTime fecha;
    private String atiende;

    public Seguimiento registrarCommand() {
        return new Seguimiento(idTicket, atiende, estatus, comentario, fecha);
    }
}
