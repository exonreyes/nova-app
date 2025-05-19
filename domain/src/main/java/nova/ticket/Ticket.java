package nova.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nova.area.Reporte;
import nova.commons.Estatus;
import nova.commons.FolioBase36;
import nova.commons.persona.Persona;
import nova.empresa.Area;
import nova.empresa.Unidad;

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
    private Area area;

    public Ticket(Integer id, Unidad unidad, Reporte titulo) {
        this.id = id;
        this.unidad = unidad;
        this.titulo = titulo;
    }
    public Ticket(Unidad unidad, Reporte titulo) {
        this.unidad = unidad;
        this.titulo = titulo;
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Ticket(Integer id, String agente, Estatus estatus, String descripcion, LocalDateTime creado) {
        this.id = id;
        this.descripcion = descripcion;
        this.agente = agente;
        this.estatus = estatus;
        this.creado = creado;
    }

    public void setFolio(String data) {
        this.folio = Optional.ofNullable(data)
                .filter(folio -> !folio.isBlank())
                .orElse(FolioBase36.generar());
    }
    public void cerrarTicket(){

    }
}
