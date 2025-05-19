package nova.estatus.web.controller;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.commons.Estatus;
import nova.estatus.handler.ObtenerEstatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("estatus")
@RestController
@RequiredArgsConstructor
public class EstatusController {
    private final ObtenerEstatus obtenerEstatus;

    @GetMapping()
    public ResponseEntity<Data<List<Estatus>>> obtenerEstatus() {
        return ResponseEntity.ok(Data.of(obtenerEstatus.execute(null), "Estatus registrados"));
    }
}
