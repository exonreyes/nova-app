package nova.empresa;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
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
