package nova.infrastructure.empresa.persistence.query;

import java.io.Serializable;
import java.time.LocalDate;

public record UnidadContactoQuery(Integer id, Integer supervisorId, String supervisorPersonaNombre,
                                  String zonaEstadoNombre, String zonaNombre, String clave, String nombre, String nivel,
                                  Boolean operativo, String direccion, String telefono,
                                  LocalDate ultimaActualizacion) implements Serializable {
}