package nova.estatus.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estatus")
public class EstatusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Size(max = 255)
    @NotNull
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public EstatusModel() {
    }

    public EstatusModel(Integer id) {
        this.id = id;
    }
}