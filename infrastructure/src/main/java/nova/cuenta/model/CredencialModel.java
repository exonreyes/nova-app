package nova.cuenta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.empresa.model.DepartamentoModel;
import nova.empresa.model.UnidadModel;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "credencial")
public class CredencialModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_unidad", nullable = false)
    private UnidadModel unidad;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_departamento", nullable = false)
    private DepartamentoModel departamento;


    @Size(max = 80)
    @NotNull
    @Column(name = "usuario", nullable = false, length = 80)
    private String usuario;

    @Size(max = 100)
    @NotNull
    @Column(name = "clave", nullable = false, length = 100)
    private String clave;

    @NotNull
    @ColumnDefault("curdate()")
    @Column(name = "creado", nullable = false, updatable = false, insertable = false)
    private LocalDate creado;

    @Size(max = 100)
    @Column(name = "comentario", length = 100)
    private String comentario;

    @Column(name = "actualizado", insertable = false, updatable = false)
    private LocalDateTime actualizado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta", nullable = false)
    private ProveedorCuentaModel cuenta;


    public CredencialModel(Integer id) {
        this.id = id;
    }

    public CredencialModel() {
    }
}