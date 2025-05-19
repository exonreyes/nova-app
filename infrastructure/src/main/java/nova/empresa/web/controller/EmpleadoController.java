package nova.empresa.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.empleado.Empleado;
import nova.empresa.handler.ObtenerEmpleadoPorCodigo;
import nova.empresa.handler.ObtenerEmpleadoPorID;
import nova.empresa.handler.ObtenerEmpleados;
import nova.empresa.web.request.FiltroEmpleadoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("empleados")
public class EmpleadoController {
    private final ObtenerEmpleados obtenerEmpleados;
    private final ObtenerEmpleadoPorID obtenerEmpleadoPorID;
    private final ObtenerEmpleadoPorCodigo obtenerEmpleadoPorCodigo;

    @GetMapping("filtrar")
    public ResponseEntity<Data<List<Empleado>>> obtenerEmpleados(@Valid FiltroEmpleadoRequest filtro) {
        return ResponseEntity.ok(obtenerEmpleados.execute(filtro.toCommand()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Data<Empleado>> obtenerEmpleado(@PathVariable Integer id) {
        return ResponseEntity.ok(Data.of(obtenerEmpleadoPorID.execute(id), "Consulta de empleado"));
    }

    @GetMapping("/codigo/{codigoEmpleado}")
    public ResponseEntity<Data<Empleado>> obtenerEmpleadoPorCodigo(@PathVariable String codigoEmpleado) {
        return ResponseEntity.ok(Data.of(obtenerEmpleadoPorCodigo.execute(codigoEmpleado), "Consulta de empleado por codigo de empleado"));
    }
}
