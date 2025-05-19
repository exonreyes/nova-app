package nova.empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nova.area.Reporte;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private Integer id;
    private String nombre;
    private Boolean externo;
    private Boolean generarFolio;
    private List<Reporte> reportes;

    public Area(Integer id) {
        this.id = id;
    }

    public Area(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Area(Integer id, String nombre, Boolean externo, Boolean generarFolio) {
        this.id = id;
        this.nombre = nombre;
        this.externo = externo;
        this.generarFolio = generarFolio;
    }

    public Area(Integer id, String nombre, List<Reporte> reportes, Boolean externo, Boolean generarFolio) {
        this.id = id;
        this.nombre = nombre;
        this.generarFolio = generarFolio;
        this.externo = externo;
        this.reportes = reportes;
    }
}
