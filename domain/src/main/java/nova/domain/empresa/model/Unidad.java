package nova.domain.empresa.model;

import lombok.Getter;
import lombok.Setter;
import nova.core.empresa.Base;
import nova.core.localizacion.Contacto;
import nova.core.persona.Persona;
import nova.domain.actividad.model.HorarioOperativo;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Unidad extends Base {
    private Base empresa;
    private String nivelOperativo;
    private List<HorarioOperativo> horarios;
    private Contacto contacto;
    private LocalDate actualizado;
    private Persona supervisor;
    private Boolean operativo;

    public Unidad(Integer id, String clave, String nombre) {
        super(id, clave, nombre);
    }

    public Unidad(Integer id) {
        super(id);
    }

    public Unidad(String nombre) {
        super(nombre);
    }

    public Unidad(String clave, String nombre) {
        super(clave, nombre);
    }
}
