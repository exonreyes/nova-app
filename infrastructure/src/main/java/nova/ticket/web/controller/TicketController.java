package nova.ticket.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.ticket.Ticket;
import nova.ticket.handler.*;
import nova.ticket.web.factory.FiltroFactory;
import nova.ticket.web.request.ActualizarTicketParams;
import nova.ticket.web.request.CrearTicketRequest;
import nova.ticket.web.request.FiltroTicketRequest;
import nova.ticket.web.request.PublicarTicketParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sci/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final GuardarTicket guardarTicket;
    private final ObtenerGeneralesPorFiltro obtenerGeneralesPorFiltro;
    private final ObtenerDetallesPorFiltro obtenerDetallesPorFiltro;
    private final ActualizarTicket actualizarTicket;
    private final PublicarTicket publicarTicket;
    private final VerificarFolio verificarFolio;
    private final FiltroFactory factory;


    @PostMapping
    public ResponseEntity<Data<Ticket>> crearTicket(@Valid @RequestBody CrearTicketRequest params) {
        return ResponseEntity.ok(Data.of(guardarTicket.execute(params.convertir()), "Ticket registrado"));
    }

    @PutMapping("actualizar")
    public ResponseEntity<Data<Boolean>> actualizarTicket(@Valid @RequestBody ActualizarTicketParams params) {
        return ResponseEntity.ok(Data.of(actualizarTicket.execute(params.convert()), "Ticket actualizado correctamente"));
    }

    @PutMapping("publicar")
    public ResponseEntity<Data<Boolean>> actualizarEstatusPublico(@Valid @RequestBody PublicarTicketParams params) {
        return ResponseEntity.ok(Data.of(publicarTicket.execute(params.convert()), "Ticket publicado correctamente"));
    }

    @GetMapping
    public ResponseEntity<Data<List<Ticket>>> obtenerGenerales(@Valid FiltroTicketRequest filter) {
        return ResponseEntity.ok(obtenerGeneralesPorFiltro.execute(factory.fromGenerales(filter)));
    }

    @GetMapping("detalles")
    public ResponseEntity<Data<Ticket>> obtenerDetalles(FiltroTicketRequest filter) {
        return ResponseEntity.ok(Data.of(obtenerDetallesPorFiltro.execute(factory.fromDetalles(filter)), "Detalles del ticket"));
    }

    @GetMapping("folio/existe")
    public ResponseEntity<Data<Boolean>> existeFolio(@RequestParam("folio") String folio) {
        return ResponseEntity.ok(Data.of(verificarFolio.execute(folio), "Consulta de folio"));
    }
}