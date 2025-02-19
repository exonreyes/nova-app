package nova.infrastructure.empresa.api;

import lombok.RequiredArgsConstructor;
import nova.application.empresa.EmpresaHandler;
import nova.core.Data;
import nova.core.empresa.Departamento;
import nova.core.empresa.Empresa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaHandler handler;

    @GetMapping
    public Data<Empresa> obtenerEmpresa(@RequestParam("idEmpresa") Integer id) {
        return new Data<>(handler.obtenerEmpresa(id));
    }

    @GetMapping("detalles")
    public Data<Empresa> obtenerDetalles(@RequestParam("idEmpresa") Integer id) {
        return new Data<>(handler.obtenerDetalles(id));
    }

    @GetMapping("departamentos")
    public Data<List<Departamento>> obtenerDepartamentos(@RequestParam("idEmpresa") Integer id) {
        return new Data<>(handler.obtenerDepartamentos(id));
    }
}
