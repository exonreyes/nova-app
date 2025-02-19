package nova.core.localizacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Zona {
    private Integer id;
    private String nombre;
    private Estado estado;

    public Zona(Integer id) {
        this.id = id;
    }

    public Zona(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Zona(Integer id, String nombre, String claveEstado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = new Estado(claveEstado);
    }

    public Zona(String nombre) {
        this.nombre = nombre;
    }

    public Zona(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public void setNombreEstado(String estado) {
        this.estado = new Estado(estado);
    }
}