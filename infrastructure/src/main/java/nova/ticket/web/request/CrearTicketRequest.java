package nova.ticket.web.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import nova.ticket.command.CrearTicketCommand;

@Getter
public class CrearTicketRequest {
    private String agente;
    @NotNull
    private Integer idEstatus;
    @NotNull
    private Integer idReporte;
    @NotNull
    private Integer idUnidad;
    private String descripcion;
    private String folio;
    private Boolean publicar;

    public CrearTicketCommand convertir() {
        return new CrearTicketCommand(idReporte, idEstatus, idUnidad, agente == null ? "N/A" : agente, folio, descripcion, publicar);
    }
}