package nova.empresa.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.empresa.command.AreaFiltro;

@Getter
@AllArgsConstructor
public class FiltroAreaRequest {
    private Boolean externo;
    private Boolean reportes;

    public AreaFiltro toCommand(Integer id) {
        return new AreaFiltro(id, externo, reportes);
    }

    public AreaFiltro toCommand() {
        return new AreaFiltro(null, externo, reportes);
    }
}
