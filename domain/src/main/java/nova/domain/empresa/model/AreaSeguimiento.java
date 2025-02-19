package nova.domain.empresa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nova.core.actividad.Reporte;
import nova.core.empresa.Area;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaSeguimiento extends Area {
    private Boolean externo;
    private List<Reporte> reportes;

    public AreaSeguimiento(Integer id) {
        super(id);
    }

    public AreaSeguimiento(Integer id, String nombre) {
        super(id, nombre);
    }

    public AreaSeguimiento(Integer id, String nombre, Boolean externo) {
        super(id, nombre);
        this.externo = externo;
    }

    public AreaSeguimiento(Integer id, String nombre, List<Reporte> reportes) {
        super(id, nombre);
        this.reportes = reportes;
    }
}
