package nova.cuenta.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioEstatusCommand {
    private Integer idProveedor;
    private String usuario;
}
