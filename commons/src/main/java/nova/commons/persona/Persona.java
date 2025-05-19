package nova.commons.persona;

import lombok.Getter;
import lombok.Setter;
import nova.commons.ubicacion.Contacto;

@Getter
@Setter
public class Persona {
    private Integer id;
    private String curp;
    private String rfc;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Contacto contacto;
    private String fechaNacimiento;
    private Genero genero;
    private EstadoCivil estadoCivil;

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
}