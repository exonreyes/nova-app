package nova.infrastructure.empresa.persistence.query;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link nova.infrastructure.empresa.persistence.entity.UnidadHorarioModel}
 */
public record UnidadHorarioQuery(Integer id, Integer operatividadId, String operatividadNombre, LocalTime apertura,
                                 LocalTime cierre) implements Serializable {
}