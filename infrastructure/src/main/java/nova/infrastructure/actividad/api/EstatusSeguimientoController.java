package nova.infrastructure.actividad.api;

import lombok.RequiredArgsConstructor;
import nova.application.actividad.EstatusSeguimientoHandler;
import nova.core.Data;
import nova.core.actividad.Estatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("general")
@RestController
@RequiredArgsConstructor
public class EstatusSeguimientoController {
    private final EstatusSeguimientoHandler estatusSeguimientoHandler;

    @GetMapping("estatus")
    public Data<List<Estatus>> obtenerEstatus() {
        return new Data<>(estatusSeguimientoHandler.obtenerEstatusSeguimiento());
    }
}
