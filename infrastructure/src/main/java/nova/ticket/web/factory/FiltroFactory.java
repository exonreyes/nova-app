package nova.ticket.web.factory;

import lombok.RequiredArgsConstructor;
import nova.global.AppConfig;
import nova.ticket.command.FiltroDetallesTicketCommand;
import nova.ticket.command.FiltroGeneralesTicketCommand;
import nova.ticket.web.request.FiltroTicketRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FiltroFactory {
    private final AppConfig appConfig;

    public FiltroGeneralesTicketCommand fromGenerales(FiltroTicketRequest request) {
        return FiltroGeneralesTicketCommand.builder()
                .pagina(request.pagina() != null ? request.pagina() : appConfig.getDefaultPage())
                .filas(request.filas() != null ? request.filas() : appConfig.getDefaultRows())
                .unidadId(request.unidadId())
                .estatusId(request.estatusId())
                .creadoDesde(request.desde())
                .publicar(request.publicar())
                .supervisorId(request.supervisorId())
                .creadoHasta(request.hasta())
                .areaId(request.areaId())
                .folio(request.folio())
                .build();
    }
    public FiltroDetallesTicketCommand fromDetalles(FiltroTicketRequest request) {
        return new FiltroDetallesTicketCommand(request.id(),request.folio());
    }
}
