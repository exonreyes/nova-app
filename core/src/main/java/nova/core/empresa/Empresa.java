package nova.core.empresa;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Empresa extends Base {
    private Integer id;
    private String clave;
    private String nombre;
    private String rfc;
    private String razonSocial;
    private String regimenCapital;
    private LocalDate inicioOperaciones;
    private String estatusPadron;
    private LocalDate ultimoCambioEstado;
    private String regimen;
    private String nombreVialidad;
    private String numeroExterior;
    private String numeroInterior;
    private String tipoVialidad;
    private String localidad;
    private String municipio;
    private String entidadFederativa;
    private String codigoPostal;
    private String colonia;
    private String calle;
    private String telefono;
    private List<Base> unidades;
    private List<Departamento> departamentos;

    public Empresa(Integer id, String clave, String nombre) {
        super(id, clave, nombre);
    }

    public Empresa(Integer id) {
        super(id);
    }

    public Empresa(String nombre) {
        super(nombre);
    }

    public Empresa(String clave, String nombre) {
        super(clave, nombre);
    }

    public Empresa(Integer id, String nombre) {
        super(id, nombre);
    }
}
