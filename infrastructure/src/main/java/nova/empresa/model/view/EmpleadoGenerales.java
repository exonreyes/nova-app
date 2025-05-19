package nova.empresa.model.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "empleado_generales")
public class EmpleadoGenerales {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "codigo_empleado", length = 20)
    private String codigoEmpleado;

    @Size(max = 30)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Size(max = 30)
    @NotNull
    @Column(name = "apellido_paterno", nullable = false, length = 30)
    private String apellidoPaterno;

    @Size(max = 30)
    @Column(name = "apellido_materno", length = 30)
    private String apellidoMaterno;

    @Size(max = 1)
    @NotNull
    @Column(name = "estatus_empleado", nullable = false, length = 1)
    private String estatus;

    @NotNull
    @Column(name = "id_puesto", nullable = false)
    private Integer idPuesto;

    @Size(max = 50)
    @NotNull
    @Column(name = "puesto", nullable = false, length = 50)
    private String puesto;

    @NotNull
    @Column(name = "id_unidad", nullable = false)
    private Integer idUnidad;

    @Size(max = 10)
    @NotNull
    @Column(name = "clave_unidad", nullable = false, length = 10)
    private String claveUnidad;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombre_unidad", nullable = false, length = 150)
    private String nombreUnidad;

}