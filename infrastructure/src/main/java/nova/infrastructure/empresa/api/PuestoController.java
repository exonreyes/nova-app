package nova.infrastructure.empresa.api;

import lombok.RequiredArgsConstructor;
import nova.application.empresa.PuestoHandler;
import nova.core.Data;
import nova.core.empresa.Puesto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("puestos")
@RestController
@RequiredArgsConstructor
public class PuestoController {
    private final PuestoHandler handler;

    @GetMapping()
    public Data<List<Puesto>> obtenerPuestos() {
        return new Data<>(handler.obtenerPuestos());
    }
}
