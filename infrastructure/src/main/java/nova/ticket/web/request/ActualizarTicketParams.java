package nova.ticket.web.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import nova.area.Reporte;
import nova.commons.Estatus;
import nova.empresa.Unidad;
import nova.ticket.Ticket;


import java.time.LocalDateTime;

@Getter
public class ActualizarTicketParams {
    private Integer idTicket;
    @NotNull
    private String agente;
    private Integer idEstatus;
    @NotNull
    private Integer idReporte;
    @NotNull
    private Integer idUnidad;
    private String descripcion;

    private String folio;
    private Boolean publicar;

    public Ticket convert() {
        Ticket ticket = new Ticket(idTicket, new Unidad(idUnidad), new Reporte(idReporte));
        ticket.setAgente(agente);
        ticket.setDescripcion(descripcion);
        ticket.setFolio(folio);
        ticket.setPublicar(publicar);
        ticket.setEstatus(new Estatus(idEstatus));
        ticket.setActualizado(LocalDateTime.now());
        return ticket;
    }

}