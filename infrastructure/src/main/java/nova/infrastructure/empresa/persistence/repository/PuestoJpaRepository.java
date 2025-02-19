package nova.infrastructure.empresa.persistence.repository;

import nova.infrastructure.empresa.persistence.entity.PuestoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuestoJpaRepository extends JpaRepository<PuestoModel, Integer> {
}