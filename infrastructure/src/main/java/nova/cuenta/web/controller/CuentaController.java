package nova.cuenta.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nova.commons.Data;
import nova.cuenta.Credencial;
import nova.cuenta.command.UsuarioEstatusCommand;
import nova.cuenta.handler.*;
import nova.cuenta.web.request.CredencialCreateRequest;
import nova.cuenta.web.request.CredencialUpdateRequest;
import nova.cuenta.web.request.FiltroCredencialRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/credenciales")
public class CuentaController {

    private final GuardarCredencial guardarCredencial;
    private final ObtenerCredenciales obtenerCredenciales;
    private final ObtenerDetallesCredencial obtenerDetallesCredencial;
    private final VerificarUsuario verificarUsuario;
    private final ActualizaCredencial actualizaCredencial;
    private final EliminarCredencial eliminarCredencial;

    @GetMapping
    public ResponseEntity<Data<?>> obtenerCredenciales(@Valid FiltroCredencialRequest filtro) {
        return ResponseEntity.ok(Data.of(obtenerCredenciales.execute(filtro.toCommand()), "Consulta de credenciales"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Data<Credencial>> obtenerDetalles(@PathVariable Integer id) {
        return ResponseEntity.ok(Data.of(obtenerDetallesCredencial.execute(id), "Detalles de credencial"));
    }

    @PostMapping
    public ResponseEntity<Data<?>> guardar(@Valid @RequestBody CredencialCreateRequest credencial) {
        guardarCredencial.execute(credencial.toCredencial());
        return ResponseEntity.ok(Data.of(true, "Credencial guardada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Data<Void>> actualizar(@PathVariable Integer id, @Valid @RequestBody CredencialUpdateRequest updateRequest) {
        actualizaCredencial.execute(updateRequest.toCredencial(id));
        return ResponseEntity.ok(Data.of(null, "Credencial actualizada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Data<?>> eliminarCredencial(@PathVariable Integer id) {
        eliminarCredencial.execute(id);
        return ResponseEntity.ok(Data.of(true, "Credencial eliminada"));
    }

    @GetMapping("/existe")
    public ResponseEntity<Data<Boolean>> existeCredencial(
            @RequestParam("idProveedor") Integer idProveedor,
            @RequestParam("usuario") String usuario) {

        boolean existe = verificarUsuario.execute(new UsuarioEstatusCommand(idProveedor, usuario));
        return ResponseEntity.ok(Data.of(existe, existe ? "El usuario ya existe" : "El usuario no existe"));
    }
}
