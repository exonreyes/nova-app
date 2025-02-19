package nova.domain.empresa.port;

import nova.domain.empresa.model.AreaSeguimiento;

import java.util.List;

public interface AreaSeguimientoDao {
    List<AreaSeguimiento> obtenerAreas(Boolean externo, Boolean agregarReportes);

    List<AreaSeguimiento> obtenerAreas(Boolean agregarReportes);

    List<AreaSeguimiento> obtenerAreas(Integer idEmpresa, Boolean agregarReportes);
}
