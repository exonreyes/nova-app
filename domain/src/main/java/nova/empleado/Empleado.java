package nova.empleado;

import lombok.Getter;
import lombok.Setter;
import nova.commons.persona.Persona;
import nova.empresa.Puesto;
import nova.empresa.Unidad;

import java.time.LocalDate;

@Getter
@Setter
public class Empleado extends Persona {
    private String ping;
    private EstatusEmpleado estatus;
    private Puesto puesto;
    private Unidad unidad;
    private LocalDate fechaAlta;
    private LocalDate actualizado;
    private String codigoEmpleado;

    public Empleado(Integer id) {
        super(id);
    }

    public Empleado(Integer id, String codigoEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(id, nombre, apellidoPaterno, apellidoMaterno);
        this.codigoEmpleado = codigoEmpleado;
    }
}
