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
@Table(name = "empleado")
public class EmpleadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad")
    private UnidadModel unidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_puesto")
    private PuestoModel puesto;

    @Size(max = 30)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Size(max = 20)
    @Column(name = "codigo_empleado", length = 20)
    private String codigo;

    @Size(max = 30)
    @NotNull
    @Column(name = "apellido_paterno", nullable = false, length = 30)
    private String apellidoPaterno;

    @Size(max = 30)
    @Column(name = "apellido_materno", length = 30)
    private String apellidoMaterno;

    @Size(max = 255)
    @Column(name = "pin")
    private String pin;

    @Size(max = 1)
    @NotNull
    @Column(name = "estatus_empleado", nullable = false, length = 1)
    private String estatus;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Basic(fetch = FetchType.LAZY)
    @Size(max = 1)
    @NotNull
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;

}