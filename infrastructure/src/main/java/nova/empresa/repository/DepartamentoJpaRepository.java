package nova.empresa.repository;

import nova.empresa.model.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoJpaRepository extends JpaRepository<DepartamentoModel, Integer> {
}