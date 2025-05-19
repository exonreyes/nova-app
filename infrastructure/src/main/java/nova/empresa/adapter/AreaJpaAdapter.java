package nova.empresa.adapter;

import lombok.RequiredArgsConstructor;
import nova.area.Reporte;
import nova.empresa.Area;
import nova.empresa.command.AreaFiltro;
import nova.empresa.port.AreaPersistencePort;
import nova.empresa.repository.AreaJpaRepository;
import nova.empresa.specifications.AreaSpecifications;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AreaJpaAdapter implements AreaPersistencePort {
    private final AreaJpaRepository repository;

    @Override
    public List<Area> obtenerAreas(AreaFiltro filtro) {
        // Obtenemos las áreas filtradas por la especificación
        return repository.findAll(AreaSpecifications.conFiltro(filtro))
                .stream()
                .map(area -> {
                    List<Reporte> reportes = null;
                    if (Boolean.TRUE.equals(filtro.getReportes())) {
                        reportes = area.getReportes().stream()
                                .map(reporte -> new Reporte(reporte.getId(), reporte.getNombre()))
                                .collect(Collectors.toList());
                    }
                    return new Area(area.getId(), area.getNombre(), reportes, area.getExterno(), area.getGenerarFolio());
                })
                .toList();
    }
}
