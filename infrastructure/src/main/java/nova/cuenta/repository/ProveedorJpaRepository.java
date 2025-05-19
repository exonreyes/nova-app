package nova.cuenta.repository;

import nova.cuenta.model.ProveedorCuentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorJpaRepository extends JpaRepository<ProveedorCuentaModel, Integer> {
}
