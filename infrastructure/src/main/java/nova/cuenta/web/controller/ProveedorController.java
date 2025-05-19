package nova.cuenta.web.controller;

import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.cuenta.Proveedor;
import nova.cuenta.handler.ObtenerProveedorPorID;
import nova.cuenta.handler.ObtenerProveedores;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    private final ObtenerProveedores obtenerProveedores;
    private final ObtenerProveedorPorID obtenerProveedorPorID;

    @GetMapping
    public ResponseEntity<Data<List<Proveedor>>> obtenerTodos() {
        return ResponseEntity.ok(Data.of(obtenerProveedores.execute(null), "Consulta de proveedores"));
    }

    @GetMapping("/{idProveedor}")
    public ResponseEntity<Data<Proveedor>> obtenerPorId(@PathVariable Integer idProveedor) {
        return ResponseEntity.ok(Data.of(obtenerProveedorPorID.execute(idProveedor), "Consulta de proveedor"));
    }
}
