package nova.infrastructure.empleado.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.infrastructure.empresa.persistence.entity.DepartamentoModel;
import nova.infrastructure.empresa.persistence.entity.PuestoModel;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class EmpleadoModel {
    @Id
    @Column(name = "id_persona", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private PersonaModel persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento")
    private DepartamentoModel departamento;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_puesto", nullable = false)
    private PuestoModel puesto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_unidad", nullable = false)
    private nova.infrastructure.empresa.persistence.entity.UnidadNegocioModel unidad;

    @Size(max = 255)
    @Column(name = "pin")
    private String pin;

    @Size(max = 1)
    @NotNull
    @Column(name = "estatus", nullable = false, length = 1)
    private String estatus;

    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @NotNull
    @Column(name = "ultima_actualizacion", nullable = false)
    private LocalDate ultimaActualizacion;

    @ColumnDefault("1")
    @Column(name = "activo")
    private Boolean activo;

}