package nova.infrastructure.empleado.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "estado_civil")
    private String estadoCivil;

    @Size(max = 255)
    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Size(max = 80)
    @Column(name = "email", length = 80)
    private String email;

    @Size(max = 16)
    @Column(name = "telefono", length = 16)
    private String telefono;

    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;

    @Size(max = 1)
    @Column(name = "genero", length = 1)
    private String genero;

    @Size(max = 30)
    @Column(name = "rfc", length = 30)
    private String rfc;

    @Size(max = 30)
    @Column(name = "curp", length = 30)
    private String curp;

}