package nova.empresa.model.query;

import nova.empresa.model.UnidadHorarioModel;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link UnidadHorarioModel}
 */
public record UnidadHorarioQuery(Integer id, Integer operatividadId, String operatividadNombre, LocalTime apertura,
                                 LocalTime cierre) implements Serializable {
}