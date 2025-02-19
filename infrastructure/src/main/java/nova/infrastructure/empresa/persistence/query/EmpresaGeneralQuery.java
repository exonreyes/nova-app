package nova.infrastructure.empresa.persistence.query;

import nova.infrastructure.empresa.persistence.entity.EmpresaModel;

import java.io.Serializable;

/**
 * DTO for {@link EmpresaModel}
 */
public record EmpresaGeneralQuery(Integer id, String nombre) implements Serializable {
}