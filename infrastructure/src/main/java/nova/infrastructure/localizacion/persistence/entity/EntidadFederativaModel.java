package nova.infrastructure.localizacion.persistence.entity;

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
@Table(name = "entidad_federativa")
public class EntidadFederativaModel {
    @Id
    @Size(max = 5)
    @Column(name = "clave", nullable = false, length = 5)
    private String clave;

    @Size(max = 60)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    @OneToMany(mappedBy = "estado")
    private Set<ZonaFederativaModel> zonaFederativas = new LinkedHashSet<>();

}