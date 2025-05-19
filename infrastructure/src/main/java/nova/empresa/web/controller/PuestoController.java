package nova.empresa.web.controller;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.empresa.Puesto;
import nova.empresa.handler.ObtenerPuestos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("puestos")
@RestController
@RequiredArgsConstructor
public class PuestoController {
    private final ObtenerPuestos obtenerPuestos;

    @GetMapping
    public ResponseEntity<Data<List<Puesto>>> obtenerPuestos() {
        return ResponseEntity.ok(Data.of(obtenerPuestos.execute(null), "Lista de Puestos registrados"));
    }
}
