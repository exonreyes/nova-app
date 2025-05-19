package nova.ticket.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.ticket.Seguimiento;
import nova.ticket.handler.GuardarSeguimiento;
import nova.ticket.handler.ObtenerSeguimientoPorTicket;
import nova.ticket.web.request.SeguimientoParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("seguimientos")
public class SeguimientoController {
    private final ObtenerSeguimientoPorTicket obtenerSeguimientoPorTicket;
    private final GuardarSeguimiento guardarSeguimiento;

    @GetMapping()
    public ResponseEntity<Data<List<Seguimiento>>> obtenerSeguimiento(@RequestParam Integer idTicket) {
        return ResponseEntity.ok(Data.of(obtenerSeguimientoPorTicket.execute(idTicket), "Consulta de seguimientos"));
    }

    @PostMapping("guardar")
    public ResponseEntity<Data<?>> agregarSeguimiento(@Valid @RequestBody SeguimientoParams historialTicket) {
        guardarSeguimiento.execute(historialTicket.toCommand());
        return ResponseEntity.ok(Data.of(null, "Seguimiento registrado correctamente"));
    }
}
