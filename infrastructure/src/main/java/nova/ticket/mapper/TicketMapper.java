package nova.ticket.mapper;

import nova.area.Reporte;
import nova.commons.Estatus;
import nova.empresa.Area;
import nova.empresa.Unidad;
import nova.ticket.Ticket;
import nova.ticket.model.query.TicketDetallesQuery;
import nova.ticket.model.query.TicketInfoQuery;

public class TicketMapper {

    public static Ticket convertirGenerales(TicketInfoQuery x) {
        Ticket data = new Ticket(x.id(), new Unidad(x.unidadId(), x.unidadClave(), x.unidadNombre()), new Reporte(x.reporteId(), x.reporteNombre()));
        data.setArea(new Area(x.reporteAreaId(), x.reporteAreaNombre()));
        data.setEstatus(new Estatus(x.estatusId(), x.estatusNombre()));
        data.setFolio(x.folio());
        data.setAgente(x.agente());
        data.setCreado(x.creado());
        data.setPublicar(x.publicar());
        data.setActualizado(x.actualizado());
        return data;
    }

    public static Ticket convertirDetalles(TicketDetallesQuery x) {
        Ticket data = new Ticket(x.id(), new Unidad(x.unidadId(), x.unidadClave(), x.unidadNombre()), new Reporte(x.reporteId(), x.reporteNombre()));
        data.setArea(new Area(x.reporteAreaId(), x.reporteAreaNombre()));
        data.setEstatus(new Estatus(x.estatusId(), x.estatusNombre()));
        data.setFolio(x.folio());
        data.setAgente(x.agente());
        data.setCreado(x.creado());
        data.setPublicar(x.publicar());
        data.setActualizado(x.actualizado());
        data.setDescripcion(x.descripcion());
        return data;
    }
}
