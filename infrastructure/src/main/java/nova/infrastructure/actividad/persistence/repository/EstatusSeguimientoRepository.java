package nova.infrastructure.actividad.persistence.repository;

import nova.infrastructure.actividad.persistence.entity.EstatusSeguimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatusSeguimientoRepository extends JpaRepository<EstatusSeguimientoModel, Integer> {
}