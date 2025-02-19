package nova.infrastructure.empresa.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.infrastructure.empleado.persistence.entity.EmpleadoModel;
import nova.infrastructure.localizacion.persistence.entity.ZonaFederativaModel;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "unidad_negocio")
public class UnidadNegocioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaModel empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor")
    private EmpleadoModel supervisor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaFederativaModel zona;

    @Size(max = 10)
    @NotNull
    @Column(name = "clave", nullable = false, length = 10)
    private String clave;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Size(max = 10)
    @Column(name = "nivel", length = 10)
    private String nivel;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "operativo", nullable = false)
    private Boolean operativo = false;

    @Size(max = 250)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 250)
    private String direccion;

    @Size(max = 13)
    @Column(name = "telefono", length = 13)
    private String telefono;

    @Column(name = "ultima_actualizacion")
    private LocalDate ultimaActualizacion;

}