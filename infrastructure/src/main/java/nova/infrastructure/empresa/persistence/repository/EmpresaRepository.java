package nova.infrastructure.empresa.persistence.repository;

import nova.infrastructure.empresa.persistence.entity.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {
    <T> Optional<T> findById(Integer integer, Class<T> type);
}