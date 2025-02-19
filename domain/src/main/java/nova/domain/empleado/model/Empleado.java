package nova.domain.empleado.model;

import lombok.Getter;
import lombok.Setter;
import nova.core.actividad.Estatus;
import nova.core.empresa.Departamento;
import nova.core.empresa.Puesto;
import nova.core.persona.Persona;
import nova.domain.empresa.model.Unidad;

import java.time.LocalDate;

@Getter
@Setter
public class Empleado extends Persona {
    private String ping;
    private Estatus estatus;
    private Puesto puesto;
    private Unidad unidad;
    private Departamento departamento;
    private LocalDate registrado;
    private LocalDate actualizado;

    public Empleado(Long id) {
        super(id);
    }

    public Empleado(String nombre) {
        super(nombre);
    }

    public Empleado(Long id, String nombre) {
        super(id, nombre);
    }
}
