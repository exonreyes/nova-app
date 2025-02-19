package nova.infrastructure.empresa.api;

import lombok.RequiredArgsConstructor;
import nova.application.empresa.AreaSeguimientoHandler;
import nova.core.Data;
import nova.domain.empresa.model.AreaSeguimiento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("area")
@RestController
@RequiredArgsConstructor
public class AreaSeguimientoController {
    private final AreaSeguimientoHandler areaSeguimientoHandler;

    @GetMapping("areas")
    public Data<List<AreaSeguimiento>> obtenerAreasSeguimiento(@RequestParam(value = "id_empresa", required = false) Integer idEmpresa, @RequestParam(value = "externo", required = false) Boolean esExterno, @RequestParam(value = "reportes", defaultValue = "false") Boolean agregarReportes) {
        return new Data<>(areaSeguimientoHandler.obtenerAreasSeguimiento(idEmpresa, esExterno, agregarReportes));
    }
}
