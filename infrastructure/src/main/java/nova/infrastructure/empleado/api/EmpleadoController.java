package nova.infrastructure.empleado.api;

import lombok.RequiredArgsConstructor;
import nova.application.empleado.EmpleadoHandler;
import nova.core.Data;
import nova.domain.empleado.model.Empleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("empleados")
public class EmpleadoController {
    private final EmpleadoHandler handler;

    @GetMapping("puesto")
    public Data<List<Empleado>> empleadosByPuestoAndEstatus(@RequestParam Integer idPuesto, @RequestParam Boolean activo) {
        return new Data<>(handler.empleadosByPuestoAndEstatus(idPuesto, activo));
    }
}
