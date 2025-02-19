package nova.core.empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Base {
    private Integer id;
    private String clave;
    private String nombre;

    public Base(Integer id) {
        this.id = id;
    }

    public Base(String nombre) {
        this.nombre = nombre;
    }

    public Base(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Base(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }
}
