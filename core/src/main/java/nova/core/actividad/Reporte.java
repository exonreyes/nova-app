package nova.core.actividad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reporte {
    private Integer id;
    private String nombre;
    private Boolean externo;

    public Reporte(Integer id) {
        this.id = id;
    }

    public Reporte(String nombre) {
        this.nombre = nombre;
    }

    public Reporte(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
