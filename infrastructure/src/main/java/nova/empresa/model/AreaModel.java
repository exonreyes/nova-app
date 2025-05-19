package nova.empresa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "area")
public class AreaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 80)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "externo", nullable = false)
    private Boolean externo = false;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "generar_folio", nullable = false)
    private Boolean generarFolio = false;

    @OneToMany(mappedBy = "area")
    private Set<ReporteAreaModel> reportes = new LinkedHashSet<>();
}