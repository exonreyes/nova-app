package nova.empresa.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.empresa.Area;
import nova.empresa.handler.ObtenerAreasPorFiltro;
import nova.empresa.web.request.FiltroAreaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("areas")
@RestController
@RequiredArgsConstructor
public class AreaController {

    private final ObtenerAreasPorFiltro obtenerAreas;

    // Obtener área individual por ID, con filtros opcionales (query params)
    @GetMapping("/{id}")
    public ResponseEntity<Data<Area>> obtenerAreaPorIdYFiltros(
            @PathVariable Integer id,
            @Valid FiltroAreaRequest filtro
    ) {
        return ResponseEntity.ok(
                Data.of(obtenerAreas.execute(filtro.toCommand(id)).getFirst(), "Área obtenida con filtros")
        );
    }

    // Obtener lista de áreas con filtros opcionales
    @GetMapping
    public ResponseEntity<Data<List<Area>>> obtenerAreas(
            @Valid FiltroAreaRequest filtro
    ) {
        return ResponseEntity.ok(
                Data.of(obtenerAreas.execute(filtro.toCommand()), "Áreas obtenidas con filtros")
        );
    }
}
