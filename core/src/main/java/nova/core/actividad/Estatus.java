package nova.core.actividad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estatus {
    private Integer id;
    private String nombre;
    private String descripcion;

    public Estatus(Integer id) {
        this.id = id;
    }

    public Estatus(String nombre) {
        this.nombre = nombre;
    }

    public Estatus(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Estatus(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
