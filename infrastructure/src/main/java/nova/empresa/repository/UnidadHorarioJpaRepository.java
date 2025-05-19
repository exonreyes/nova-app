package nova.empresa.repository;

import nova.empresa.model.UnidadHorarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadHorarioJpaRepository extends JpaRepository<UnidadHorarioModel, Integer> {
    <T> List<T> findByUnidadId(Integer id, Class<T> type);

    Integer id(Integer id);
}