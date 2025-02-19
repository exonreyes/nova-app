package nova.core.empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private Integer id;
    private String nombre;

    public Area(Integer id) {
        this.id = id;
    }

    public Area(String nombre) {
        this.nombre = nombre;
    }
}
