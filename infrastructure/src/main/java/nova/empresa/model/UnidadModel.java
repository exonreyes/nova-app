package nova.empresa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.localizacion.model.ZonaModel;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "unidad")
public class UnidadModel {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 10)
    @NotNull
    @Column(name = "clave", nullable = false, length = 10)
    private String clave;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Size(max = 15)
    @Column(name = "nivel", length = 15)
    private String nivel;

    @ColumnDefault("1")
    @Column(name = "operativo")
    private Boolean operativo;

    @Size(max = 255)
    @NotNull
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Size(max = 13)
    @NotNull
    @Column(name = "telefono", nullable = false, length = 13)
    private String telefono;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaModel zona;

    @Size(max = 10)
    @NotNull
    @Column(name = "segmento_negocio", nullable = false, length = 10)
    private String segmento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor")
    private EmpleadoModel supervisor;

    public UnidadModel() {
    }

    public UnidadModel(Integer id) {
        this.id = id;
    }
}