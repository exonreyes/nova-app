package nova.commons.ubicacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Estado {
    private Integer id;
    private String codigo;
    private String nombre;
    private List<Zona> zonas;

    public Estado(Integer id) {
        this.id = id;
    }

    public Estado(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
