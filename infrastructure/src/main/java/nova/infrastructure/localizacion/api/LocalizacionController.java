package nova.infrastructure.localizacion.api;

import lombok.RequiredArgsConstructor;
import nova.application.localizacion.EstadoHandler;
import nova.core.Data;
import nova.core.localizacion.Estado;
import nova.core.localizacion.Zona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("entidad-federativa")
@RestController
@RequiredArgsConstructor
public class LocalizacionController {
    private final EstadoHandler handler;

    @GetMapping("entidades")
    public Data<List<Estado>> obtenerEntidades(@RequestParam(defaultValue = "false", name = "agregarZonas") Boolean agregarZonas) {
        return new Data<>(handler.obtenerEntidadesFederativas(agregarZonas));
    }

    @GetMapping("entidad")
    public Data<Estado> obtenerEntidad(@RequestParam(defaultValue = "false", name = "agregarZona") Boolean agregarZonas, @RequestParam String clave) {
        return new Data<>(handler.obtenerEntidadFederativa(clave, agregarZonas));
    }

    @GetMapping("zonas")
    public Data<List<Zona>> obtenerZonas() {
        return new Data<>(handler.obtenerZonas());
    }
}