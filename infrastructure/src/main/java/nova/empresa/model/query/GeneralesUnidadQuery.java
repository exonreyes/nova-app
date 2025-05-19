package nova.empresa.model.query;

import nova.empresa.model.UnidadModel;

import java.io.Serializable;

/**
 * DTO for {@link UnidadModel}
 */
public record GeneralesUnidadQuery(Integer id, String clave, String nombre, String nivel, Boolean operativo,
                                   String segmento) implements Serializable {
}