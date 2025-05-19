package nova.ticket.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.empresa.model.ReporteAreaModel;
import nova.empresa.model.UnidadModel;
import nova.estatus.model.EstatusModel;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class TicketModel {
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
    @JoinColumn(name = "id_estatus", nullable = false)
    private EstatusModel estatus;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reporte", nullable = false)
    private ReporteAreaModel reporte;

    @Size(max = 80)
    @NotNull
    @Column(name = "folio", nullable = false, length = 80)
    private String folio;

    @Size(max = 50)
    @NotNull
    @Column(name = "agente", nullable = false, length = 50)
    private String agente;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;


    @ColumnDefault("0")
    @Column(name = "publicar", nullable = false)
    private Boolean publicar = false;

    @Column(name = "creado", insertable = false)
    private LocalDateTime creado;

    @ColumnDefault("current_timestamp()")
    @Column(name = "ultima_actualizacion", nullable = false)
    private LocalDateTime actualizado;

    public TicketModel(Integer id) {
        this.id = id;
    }

    public TicketModel() {
    }
}