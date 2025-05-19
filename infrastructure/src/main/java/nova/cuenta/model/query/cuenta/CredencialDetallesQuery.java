package nova.cuenta.model.query.cuenta;

import java.io.Serializable;
import java.time.LocalDateTime;

public record CredencialDetallesQuery(Integer id, Integer unidadId, String unidadClave, String unidadNombre,
                                      Integer departamentoId, String departamentoNombre, String usuario, String clave,
                                      String comentario, Integer cuentaId, String cuentaNombre,
                                      LocalDateTime actualizado) implements Serializable {
}