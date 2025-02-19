package nova.core.persona;

import lombok.Getter;
import lombok.Setter;
import nova.core.localizacion.Contacto;

@Getter
@Setter
public class Persona {
    private Long id;
    private String curp;
    private String rfc;
    private String nombre;
    private Contacto contacto;
    private String fechaNacimiento;
    private Genero genero;
    private EstadoCivil estadoCivil;

    public Persona(Long id) {
        this.id = id;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}