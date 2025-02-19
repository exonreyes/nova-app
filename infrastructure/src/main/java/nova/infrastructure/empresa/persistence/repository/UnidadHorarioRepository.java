package nova.infrastructure.empresa.persistence.repository;

import nova.infrastructure.empresa.persistence.entity.UnidadHorarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadHorarioRepository extends JpaRepository<UnidadHorarioModel, Integer> {
    <T> List<T> findByUnidadId(Integer id, Class<T> type);
}