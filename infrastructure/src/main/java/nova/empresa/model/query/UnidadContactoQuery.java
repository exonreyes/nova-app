package nova.empresa.model.query;

import nova.empresa.model.UnidadModel;

import java.io.Serializable;

/**
 * DTO for {@link UnidadModel}
 */
public record UnidadContactoQuery(Integer id, String clave, String nombre,
                                  String nivel, Boolean operativo,
                                  String direccion, String telefono,
                                  Integer zonaId, Integer zonaEstadoId,
                                  String zonaEstadoCodigo, String zonaEstadoNombre, String zonaNombre,
                                  String segmento, Integer supervisorId, String supervisorNombre,
                                  String supervisorCodigo, String supervisorApellidoPaterno,
                                  String supervisorApellidoMaterno) implements Serializable {
}