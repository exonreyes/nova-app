package nova.core.actividad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operatividad {
    private Integer id;
    private String nombre;

    public Operatividad(Integer id) {
        this.id = id;
    }

    public Operatividad(String nombre) {
        this.nombre = nombre;
    }
}
