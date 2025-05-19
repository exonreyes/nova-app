package nova.localizacion.repository;

import nova.localizacion.model.ZonaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZonaJpaRepository extends JpaRepository<ZonaModel, Integer> {
    <T> List<T> findBy(Class<T> type);
}