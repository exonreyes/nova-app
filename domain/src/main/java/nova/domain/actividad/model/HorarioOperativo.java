package nova.domain.actividad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nova.core.actividad.Operatividad;
import nova.domain.empresa.model.Unidad;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioOperativo extends Operatividad {
    private Integer idHorario;
    private LocalTime apertura;
    private LocalTime cierre;
    private Unidad unidad;

    public HorarioOperativo(Integer id, Integer idOperatividad, String nombre, LocalTime apertura, LocalTime cierre) {
        super(idOperatividad, nombre);
        this.idHorario = id;
        this.apertura = apertura;
        this.cierre = cierre;
    }

}
