package nova.cuenta.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FiltroCuentaCmd {
    private Integer idProveedor, idUnidad, idDepartamento;
}
