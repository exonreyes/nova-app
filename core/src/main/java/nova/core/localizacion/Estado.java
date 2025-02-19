package nova.core.localizacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado {
    private String clave;
    private String nombre;
    private List<Zona> zonas;

    public Estado(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }
}
