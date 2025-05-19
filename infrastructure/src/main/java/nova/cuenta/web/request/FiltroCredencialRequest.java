package nova.cuenta.web.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.cuenta.command.FiltroCuentaCmd;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class FiltroCredencialRequest implements Serializable {
    @NotNull
    private Integer idProveedor;
    private Integer idUnidad;
    private Integer idDepartamento;

    public FiltroCuentaCmd toCommand() {
        return new FiltroCuentaCmd(idProveedor, idUnidad, idDepartamento);
    }
}
