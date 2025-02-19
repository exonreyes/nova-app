package nova.infrastructure.empresa.persistence.adapter;

import lombok.RequiredArgsConstructor;
import nova.core.actividad.Reporte;
import nova.domain.empresa.model.AreaSeguimiento;
import nova.domain.empresa.port.AreaSeguimientoDao;
import nova.infrastructure.empresa.persistence.repository.AreaSeguimientoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AreaSeguimientoJpaAdapter implements AreaSeguimientoDao {
    private final AreaSeguimientoRepository areaSeguimientoRepository;

    @Override
    public List<AreaSeguimiento> obtenerAreas(Boolean externo, Boolean agregarReportes) {
        if (agregarReportes) {
            return areaSeguimientoRepository.obtenerConReportes(externo).stream()
                    .map(x -> new AreaSeguimiento(x.getId(), x.getNombre(), x.getReporteTickets()
                            .stream().map(y -> new Reporte(y.getId(), y.getNombre())).toList()))
                    .toList();
        } else {
            return areaSeguimientoRepository.findByExterno(externo).stream()
                    .map(x -> new AreaSeguimiento(x.getId(), x.getNombre()))
                    .toList();
        }
    }

    @Override
    public List<AreaSeguimiento> obtenerAreas(Boolean agregarReportes) {
        if (agregarReportes) {
            return areaSeguimientoRepository.obtenerConReportes().stream()
                    .map(x -> new AreaSeguimiento(x.getId(), x.getNombre(), x.getReporteTickets()
                            .stream().map(y -> new Reporte(y.getId(), y.getNombre())).toList()))
                    .toList();
        } else {
            return areaSeguimientoRepository.findAll().stream()
                    .map(x -> new AreaSeguimiento(x.getId(), x.getNombre()))
                    .toList();
        }

    }

    @Override
    public List<AreaSeguimiento> obtenerAreas(Integer idEmpresa, Boolean agregarReportes) {
        if (agregarReportes) {
            return areaSeguimientoRepository.obtenerPorEmpresaConReportes(idEmpresa).stream().
                    map(x -> new AreaSeguimiento(x.getId(), x.getNombre(), x.getReporteTickets()
                            .stream().map(y -> new Reporte(y.getId(), y.getNombre())).toList()))
                    .toList();
        } else {
            return areaSeguimientoRepository.findByEmpresa_Id(idEmpresa).stream().
                    map(x -> new AreaSeguimiento(x.getId(), x.getNombre()))
                    .toList();
        }
    }


}
