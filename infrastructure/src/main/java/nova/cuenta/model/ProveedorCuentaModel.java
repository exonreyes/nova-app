package nova.cuenta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "proveedor_cuenta")
public class ProveedorCuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 15)
    @Column(name = "icon", length = 15)
    private String icon;

    @OneToMany
    private Set<CredencialModel> credenciales = new LinkedHashSet<>();

    public ProveedorCuentaModel(Integer id) {
        this.id = id;
    }

    public ProveedorCuentaModel() {
    }
}