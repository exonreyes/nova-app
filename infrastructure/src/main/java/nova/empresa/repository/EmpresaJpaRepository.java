package nova.empresa.repository;

import nova.empresa.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaJpaRepository extends JpaRepository<EmpresaModel, Integer> {
    <T> Optional<T> findById(Integer integer, Class<T> type);
}