package nova.core.localizacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {
    private String email;
    private String telefono;
    private String direccion;
    private Zona zona;

    public Contacto(String telefono) {
        this.telefono = telefono;
    }

    public Contacto(String telefono, String direccion) {
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Contacto(String telefono, String direccion, Zona zona) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.zona = zona;
    }
}