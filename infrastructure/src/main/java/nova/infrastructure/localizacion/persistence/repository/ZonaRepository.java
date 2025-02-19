package nova.infrastructure.localizacion.persistence.repository;

import nova.infrastructure.localizacion.persistence.entity.ZonaFederativaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZonaRepository extends JpaRepository<ZonaFederativaModel, Integer> {
    <T> List<T> findBy(Class<T> type);
}