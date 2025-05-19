package nova.empresa.repository;

import nova.empresa.model.PuestoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuestoJpaRepository extends JpaRepository<PuestoModel, Integer> {
}