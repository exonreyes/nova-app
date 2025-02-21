package nova.domain.empresa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nova.core.FolioBase36;
import nova.core.actividad.Estatus;
import nova.core.actividad.Reporte;
import nova.core.persona.Persona;
import nova.domain.actividad.model.Seguimiento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    private Integer id;
    private Unidad unidad;
    private Reporte titulo;
    private String descripcion;
    private String folio;
    private String agente;
    private Boolean publicar;
    private Estatus estatus;
    private List<Persona> compartir;
    private LocalDateTime creado;
    private LocalDateTime actualizado;
    private List<Seguimiento> seguimientos;
    private AreaSeguimiento area;

    public Ticket(Integer id, Unidad unidad, Reporte titulo) {
        this.id = id;
        this.unidad = unidad;
        this.titulo = titulo;
    }

    public Ticket(Integer id, String agente, String estatus, String descripcion, LocalDateTime creado) {
        this.id = id;
        this.descripcion = descripcion;
        this.agente = agente;
        this.estatus = new Estatus(estatus);
        this.creado = creado;
    }

    public void setFolio(String data) {
        this.folio = Optional.ofNullable(data)
                .filter(folio -> !folio.isBlank())
                .orElse(FolioBase36.generar());
    }
}
