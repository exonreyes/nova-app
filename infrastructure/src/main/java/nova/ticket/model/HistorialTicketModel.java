package nova.ticket.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.estatus.model.EstatusModel;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "historial_ticket")
public class HistorialTicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "id_ticket", nullable = false)
    private Integer idTicket;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estatus", nullable = false)
    private EstatusModel estatus;

    @Size(max = 50)
    @Column(name = "agente", length = 50)
    private String agente;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "creado", nullable = false)
    private LocalDateTime creado;

}