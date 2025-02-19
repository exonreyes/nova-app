package nova.infrastructure.actividad.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nova.infrastructure.empresa.persistence.entity.AreaSeguimientoModel;

@Getter
@Setter
@Entity
@Table(name = "reporte_tickets")
public class ReporteTicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area")
    private AreaSeguimientoModel idArea;

    @Column(name = "nombre", nullable = false)
    private String nombre;

}