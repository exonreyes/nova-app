package nova.ticket.web.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import nova.ticket.Ticket;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Setter
public class PublicarTicketParams {
    @NotNull
    private Integer idTicket;
    @NotNull
    private Boolean publicar;

    public Ticket convert() {
        Ticket ticket = new Ticket(idTicket);
        ticket.setPublicar(publicar);
        ticket.setActualizado(LocalDateTime.now());
        return ticket;
    }
}
