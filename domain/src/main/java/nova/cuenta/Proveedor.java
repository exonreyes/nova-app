package nova.cuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Proveedor {
    private Integer id;
    private String nombre;
    private String icon;
    private List<Credencial> credenciales;

    public Proveedor(Integer id) {
        this.id = id;
    }

    public Proveedor(Integer id, String nombre, String icon) {
        this.id = id;
        this.nombre = nombre;
        this.icon = icon;
    }

    public Proveedor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
