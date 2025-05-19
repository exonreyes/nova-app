package nova.cuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import nova.empresa.Departamento;
import nova.empresa.Unidad;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Credencial {
    private Integer id;
    private Proveedor proveedor;
    private Unidad unidad;
    private Departamento departamento;
    private String clave;
    private String usuario;
    private String comentario;
    private LocalDateTime actualizado;

    public Credencial(Integer id, String usuario, String clave, LocalDateTime actualizado, String comentario) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.actualizado = actualizado;
        this.comentario = comentario;
    }

    public Credencial(Integer id, String usuario, String clave, String comentario) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.comentario = comentario;
    }


}
