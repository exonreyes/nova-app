package nova.empresa.web.controller;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.empresa.Departamento;
import nova.empresa.Empresa;
import nova.empresa.handler.ObtenerDepartamentos;
import nova.empresa.handler.ObtenerDetallesEmpresa;
import nova.empresa.handler.ObtenerEmpresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final ObtenerDepartamentos obtenerDepartamentos;
    private final ObtenerDetallesEmpresa detallesEmpresa;
    private final ObtenerEmpresa obtenerEmpresa;

    @GetMapping
    public ResponseEntity<Data<Empresa>> obtenerEmpresa(@RequestParam("idEmpresa") Integer id) {
        return ResponseEntity.ok(Data.of(obtenerEmpresa.execute(id), "Consulta existosa"));
    }

    @GetMapping("detalles")
    public ResponseEntity<Data<Empresa>> obtenerDetalles(@RequestParam("idEmpresa") Integer id) {
        return ResponseEntity.ok(Data.of(detallesEmpresa.execute(id), "Consulta existosa"));
    }

    @GetMapping("departamentos")
    public ResponseEntity<Data<List<Departamento>>> obtenerDepartamentos() {
        return ResponseEntity.ok(Data.of(obtenerDepartamentos.execute(null), "Consulta existosa"));
    }

}
