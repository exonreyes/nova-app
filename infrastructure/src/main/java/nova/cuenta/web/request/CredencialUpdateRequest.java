package nova.cuenta.web.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import nova.cuenta.Credencial;
import nova.cuenta.Proveedor;
import nova.empresa.Departamento;
import nova.empresa.Unidad;

import java.io.Serializable;

/**
 * DTO for {@link Credencial}
 */
@Getter
public class CredencialUpdateRequest implements Serializable {
    @Positive
    private Integer proveedorId;
    private Integer unidadId;
    private Integer departamentoId;
    private String clave;
    private String usuario;
    private String comentario;

    public Credencial toCredencial(Integer id) {
        Credencial credencial = new Credencial(id, usuario, clave, comentario);
        credencial.setProveedor(proveedorId == null ? null : new Proveedor(proveedorId));
        credencial.setUnidad(unidadId == null ? null : new Unidad(unidadId));
        credencial.setDepartamento(departamentoId == null ? null : new Departamento(departamentoId));
        return credencial;
    }
}