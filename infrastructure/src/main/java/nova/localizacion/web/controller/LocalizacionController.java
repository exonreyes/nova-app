package nova.localizacion.web.controller;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.commons.ubicacion.Estado;
import nova.commons.ubicacion.Zona;
import nova.localizacion.handler.ObtenerEstados;
import nova.localizacion.handler.ObtenerZonas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("estados")
@RestController
@RequiredArgsConstructor
public class LocalizacionController {
    private final ObtenerEstados obtenerEstados;
    private final ObtenerZonas obtenerZonas;

    @GetMapping()
    public ResponseEntity<Data<List<Estado>>> obtenerEstados(@RequestParam(defaultValue = "false", name = "zonas") Boolean zonas) {
        return ResponseEntity.ok(Data.of(obtenerEstados.execute(zonas), "Estados registrados"));
    }

    @GetMapping("zonas")
    public ResponseEntity<Data<List<Zona>>> obtenerZonas() {
        return ResponseEntity.ok(Data.of(obtenerZonas.execute(null), "Zonas registrados"));
    }
}