package nova.cuenta.web.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import nova.cuenta.Credencial;
import nova.cuenta.Proveedor;
import nova.empresa.Departamento;
import nova.empresa.Unidad;

import java.io.Serializable;

@Getter
public class CredencialCreateRequest implements Serializable {
    @Positive
    @NotNull(message = "El ID del proveedor es requerido")
    private Integer proveedorId;
    @NotNull(message = "El ID de la unidad es requerida")
    private Integer unidadId;
    @NotNull(message = "El ID del departamento es requerido")
    private Integer departamentoId;
    @NotNull(message = "La clave es requerida")
    private String clave;
    @NotNull(message = "El usuario es requerido")
    private String usuario;
    private String comentario;

    public Credencial toCredencial() {
        Credencial credencial = new Credencial(null, usuario, clave, comentario);
        credencial.setProveedor(new Proveedor(proveedorId));
        credencial.setUnidad(new Unidad(unidadId));
        credencial.setDepartamento(new Departamento(departamentoId));
        return credencial;
    }
}
