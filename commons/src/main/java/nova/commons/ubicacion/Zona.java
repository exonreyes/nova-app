package nova.commons.ubicacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Zona {
    private Integer id;
    private String nombre;
    private Estado estado;

    public Zona(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Zona(Integer id, String nombre, Integer idEstado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = new Estado(idEstado);
    }
}