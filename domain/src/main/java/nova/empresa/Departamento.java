package nova.empresa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Departamento {
    private Integer id;
    private String nombre;

    public Departamento(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Departamento(Integer id) {
        this.id = id;
    }
}
