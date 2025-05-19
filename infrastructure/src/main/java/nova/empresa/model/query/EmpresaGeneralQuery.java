package nova.empresa.model.query;

import java.io.Serializable;

public record EmpresaGeneralQuery(Integer id, String nombre) implements Serializable {
}