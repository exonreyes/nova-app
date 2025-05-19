package nova.empresa.repository;

import nova.empresa.model.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AreaJpaRepository extends JpaRepository<AreaModel, Integer>, JpaSpecificationExecutor<AreaModel> {
}