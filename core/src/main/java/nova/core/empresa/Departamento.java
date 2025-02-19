package nova.core.empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
    private Integer id;
    private String nombre;
    private List<Puesto> puestos;

    public Departamento(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Departamento(Integer id) {
        this.id = id;
    }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }
}
