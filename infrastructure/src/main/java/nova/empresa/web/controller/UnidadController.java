package nova.empresa.web.controller;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.empresa.HorarioOperativo;
import nova.empresa.Unidad;
import nova.empresa.handler.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unidades")
@RequiredArgsConstructor
public class UnidadController {

    private final ObtenerHorariosUnidad obtenerHorariosUnidad;
    private final ObtenerContactoUnidad obtenerContacto;
    private final ObtenerUnidadesPorSupervisor obtenerUnidadesPorSupervisor;
    private final ObtenerUnidades obtenerUnidades;
    private final ObtenerUnidadesPorZona obtenerUnidadesPorZona;

    @GetMapping
    public ResponseEntity<Data<List<Unidad>>> obtenerTodas() {
        return ResponseEntity.ok(Data.of(obtenerUnidades.execute(null), "Consulta de unidades"));
    }

    @GetMapping("/zona/{zonaId}")
    public ResponseEntity<Data<List<Unidad>>> obtenerPorZona(@PathVariable("zonaId") Integer zonaId) {
        return ResponseEntity.ok(Data.of(obtenerUnidadesPorZona.execute(zonaId), "Consulta de unidades por zona"));
    }

    @GetMapping("/supervisor/{supervisorId}")
    public ResponseEntity<Data<List<Unidad>>> obtenerPorSupervisor(@PathVariable("supervisorId") Integer supervisorId) {
        return ResponseEntity.ok(Data.of(obtenerUnidadesPorSupervisor.execute(supervisorId), "Consulta de unidades por supervisor"));
    }

    @GetMapping("/{id}/contacto")
    public ResponseEntity<Data<Unidad>> obtenerContacto(@PathVariable Integer id) {
        return ResponseEntity.ok(Data.of(obtenerContacto.execute(id), "Información de contacto de la unidad"));
    }

    @GetMapping("/{id}/horarios")
    public ResponseEntity<Data<List<HorarioOperativo>>> obtenerHorarios(@PathVariable Integer id) {
        return ResponseEntity.ok(Data.of(obtenerHorariosUnidad.execute(id), "Consulta de horarios de la unidad"));
    }
}
