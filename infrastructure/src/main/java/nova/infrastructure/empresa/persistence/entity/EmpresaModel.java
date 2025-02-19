package nova.infrastructure.empresa.persistence.entity;

import jakarta.persistence.*;
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

    @Column(name = "rfc", nullable = false, length = 50)
    private String rfc;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "razon_social", nullable = false, length = 80)
    private String razonSocial;

    @Column(name = "regimen_capital", length = 150)
    private String regimenCapital;

    @Column(name = "inicio_operaciones")
    private LocalDate inicioOperaciones;

    @Column(name = "estatus_padron", length = 30)
    private String estatusPadron;

    @Column(name = "ultimo_cambio_estado")
    private LocalDate ultimoCambioEstado;

    @Column(name = "regimen", length = 200)
    private String regimen;

    @Column(name = "nombre_vialidad")
    private String nombreVialidad;

    @Column(name = "numero_exterior", length = 20)
    private String numeroExterior;

    @Column(name = "numero_interior", length = 20)
    private String numeroInterior;

    @Column(name = "tipo_vialidad")
    private String tipoVialidad;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "entidad_federativa", length = 50)
    private String entidadFederativa;

    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @Column(name = "colonia")
    private String colonia;

    @Column(name = "calle")
    private String calle;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono", length = 12)
    private String telefono;

}