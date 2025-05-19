package nova.empresa.web.request;

import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.empresa.command.EmpleadoFiltroCommand;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class FiltroEmpleadoRequest implements Serializable {
    private Integer idPuesto;
    private String estatus;
    private Integer idUnidad;
    private Integer page = 0;
    @Max(1000)
    private Integer size = 100;

    public EmpleadoFiltroCommand toCommand() {
        return new EmpleadoFiltroCommand(idPuesto, idUnidad, estatus != null && !estatus.isBlank() ? estatus : null, page, size);
    }
}
