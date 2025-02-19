package nova.core.empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Puesto {
    private Integer id;
    private String nombre;

    public Puesto(Integer id) {
        this.id = id;
    }

    public Puesto(String nombre) {
        this.nombre = nombre;
    }
}
