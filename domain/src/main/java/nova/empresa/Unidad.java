package nova.empresa;

import lombok.Getter;
import lombok.Setter;
import nova.commons.ubicacion.Contacto;
import nova.empleado.Empleado;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Unidad extends Entidad {
    private String nivel;
    private List<HorarioOperativo> horarios;
    private Contacto contacto;
    private LocalDate actualizado;
    private Empleado supervisor;
    private Boolean operativo;

    public Unidad(Integer id, String clave, String nombre, String segmento) {
        super(id, clave, nombre, segmento);
    }

    public Unidad(Integer id) {
        super(id);
    }

    public Unidad(String nombre) {
        super(nombre);
    }

    public Unidad(Integer id, String clave, String nombre) {
        super(id, clave, nombre);
    }

    public Unidad(String clave, String nombre) {
        super(clave, nombre);
    }

}
