package nova.empresa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "unidad_horario")
public class UnidadHorarioModel {
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
    @JoinColumn(name = "id_operatividad", nullable = false)
    private OperatividadModel operatividad;

    @NotNull
    @Column(name = "apertura", nullable = false)
    private LocalTime apertura;

    @NotNull
    @Column(name = "cierre", nullable = false)
    private LocalTime cierre;

}