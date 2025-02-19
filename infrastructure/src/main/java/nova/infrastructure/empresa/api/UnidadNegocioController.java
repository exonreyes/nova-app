package nova.infrastructure.empresa.api;

import lombok.RequiredArgsConstructor;
import nova.application.empresa.UnidadNegocioHandler;
import nova.core.Data;
import nova.core.empresa.Base;
import nova.domain.empresa.model.Unidad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("unidad")
@RestController
@RequiredArgsConstructor
public class UnidadNegocioController {
    private final UnidadNegocioHandler handler;

    @GetMapping("unidades")
    public Data<List<Base>> obtenerPorEmpresa(@RequestParam("idEmpresa") Integer ID) {
        return new Data<>(handler.obtenerUnidadesNegocio(ID));
    }

    @GetMapping("unidades-zona")
    public Data<List<Base>> obtenerPorZona(@RequestParam("idZona") Integer ID) {
        return new Data<>(handler.obtenerUnidadesPorZona(ID));
    }

    @GetMapping("unidades-supervisor")
    public Data<List<Base>> obtenerPorSupervisor(@RequestParam("idSupervisor") Long ID) {
        return new Data<>(handler.obtenerUnidadesPorSupervisor(ID));
    }

    @GetMapping("contacto")
    public Data<Unidad> obtenerContacto(@RequestParam("idUnidad") Integer ID) {
        return new Data<>(handler.obtenerContacto(ID));
    }

    @GetMapping("horarios")
    public Data<Unidad> obtenerHorarios(@RequestParam("idUnidad") Integer ID) {
        return new Data<>(handler.obtenerHorarios(ID));
    }
}
