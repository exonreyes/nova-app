package nova.empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Entidad {
    private Integer id;
    private String clave;
    private String nombre;
    private String segmento;

    public Entidad(Integer id) {
        this.id = id;
    }

    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    public Entidad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Entidad(Integer id, String clave, String nombre) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
    }

    public Entidad(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }
}
