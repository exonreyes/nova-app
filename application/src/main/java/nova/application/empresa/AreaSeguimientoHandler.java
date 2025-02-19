package nova.application.empresa;

import lombok.RequiredArgsConstructor;
import nova.domain.empresa.model.AreaSeguimiento;
import nova.domain.empresa.port.AreaSeguimientoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AreaSeguimientoHandler {
    private final AreaSeguimientoDao areaSeguimientoDao;

    public List<AreaSeguimiento> obtenerAreasSeguimiento(Integer idEmpresa, Boolean externo, Boolean agregarReportes) {
        if (idEmpresa == null) {
            if (externo == null) {
                return areaSeguimientoDao.obtenerAreas(agregarReportes);
            }
            return areaSeguimientoDao.obtenerAreas(externo, agregarReportes);
        }
        if (externo != null && agregarReportes != null) {
            return areaSeguimientoDao.obtenerAreas(externo, agregarReportes);
        }
        return areaSeguimientoDao.obtenerAreas(idEmpresa, agregarReportes);
    }


}
