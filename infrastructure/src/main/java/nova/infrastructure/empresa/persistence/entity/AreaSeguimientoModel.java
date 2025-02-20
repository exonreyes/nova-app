package nova.infrastructure.empresa.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nova.infrastructure.actividad.persistence.entity.ReporteTicketModel;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "area_seguimiento")
public class AreaSeguimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private EmpresaModel empresa;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @ColumnDefault("0")
    @Column(name = "externo")
    private Boolean externo;

    @OneToMany(mappedBy = "area")
    private Set<ReporteTicketModel> reporteTickets = new LinkedHashSet<>();

}