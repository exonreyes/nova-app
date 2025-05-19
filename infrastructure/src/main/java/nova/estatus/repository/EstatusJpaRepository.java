package nova.estatus.repository;

import nova.estatus.model.EstatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatusJpaRepository extends JpaRepository<EstatusModel, Integer> {
}