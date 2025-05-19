package nova.ticket.command;

public record CrearTicketCommand(Integer idReporte, Integer idEstatus, Integer idUnidad,
                                 String agente, String folio, String descripcion, Boolean publicar) {
}
