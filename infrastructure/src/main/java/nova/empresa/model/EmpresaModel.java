package nova.empresa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class EmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "rfc", nullable = false, length = 50)
    private String rfc;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 80)
    @NotNull
    @Column(name = "razon_social", nullable = false, length = 80)
    private String razonSocial;

    @Size(max = 150)
    @Column(name = "regimen_capital", length = 150)
    private String regimenCapital;

    @Column(name = "inicio_operaciones")
    private LocalDate inicioOperaciones;

    @Size(max = 30)
    @Column(name = "estatus_padron", length = 30)
    private String estatusPadron;

    @Column(name = "ultimo_cambio_estado")
    private LocalDate ultimoCambioEstado;

    @Size(max = 200)
    @Column(name = "regimen", length = 200)
    private String regimen;

    @Size(max = 255)
    @Column(name = "nombre_vialidad")
    private String nombreVialidad;

    @Size(max = 20)
    @Column(name = "numero_exterior", length = 20)
    private String numeroExterior;

    @Size(max = 20)
    @Column(name = "numero_interior", length = 20)
    private String numeroInterior;

    @Size(max = 255)
    @Column(name = "tipo_vialidad")
    private String tipoVialidad;

    @Size(max = 255)
    @Column(name = "localidad")
    private String localidad;

    @Size(max = 255)
    @Column(name = "municipio")
    private String municipio;

    @Size(max = 50)
    @Column(name = "entidad_federativa", length = 50)
    private String entidadFederativa;

    @Size(max = 10)
    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @Size(max = 255)
    @Column(name = "colonia")
    private String colonia;

    @Size(max = 255)
    @Column(name = "calle")
    private String calle;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 12)
    @Column(name = "telefono", length = 12)
    private String telefono;

}