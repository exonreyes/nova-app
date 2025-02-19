package nova.domain.empresa.model;

import lombok.Getter;
import lombok.Setter;
import nova.core.empresa.Base;
import nova.core.empresa.Departamento;
import nova.core.localizacion.Contacto;

import java.util.List;

@Getter
@Setter
public class Empresa extends Base {
    private List<Departamento> departamentos;
    private Contacto contacto;

    public Empresa(Integer id, String clave, String nombre) {
        super(id, clave, nombre);
    }

    public Empresa(Integer id) {
        super(id);
    }

    public Empresa(String nombre) {
        super(nombre);
    }

    public Empresa(Integer id, String nombre) {
        super(id, nombre);
    }

    public Empresa(String clave, String nombre) {
        super(clave, nombre);
    }
}
