package nova.empresa.model.query;

import nova.empresa.model.EmpleadoModel;

/**
 * Projection for {@link EmpleadoModel}
 */
public interface EmpleadoQuery {
    Integer getId();

    String getNombre();

    String getCodigo();

    String getApellidoMaterno();

    String getApellidoPaterno();

    String getEstatus();
}