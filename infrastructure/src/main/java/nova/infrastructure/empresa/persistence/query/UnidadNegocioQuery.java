package nova.infrastructure.empresa.persistence.query;

import java.io.Serializable;

public record UnidadNegocioQuery(Integer id, String clave, String nombre) implements Serializable {
}