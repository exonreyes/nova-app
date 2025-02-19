package nova.infrastructure.empleado.persistence.query;

import java.io.Serializable;

/**
 * DTO for {@link nova.infrastructure.empleado.persistence.entity.EmpleadoModel}
 */
public record PersonaQuery(Long id, String personaNombre) implements Serializable {
}