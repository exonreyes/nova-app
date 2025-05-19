package nova.cuenta.repository;

import nova.cuenta.model.CredencialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CredencialJpaRepository extends JpaRepository<CredencialModel, Integer>, JpaSpecificationExecutor<CredencialModel> {
    <T> Optional<T> findById(Integer integer, Class<T> type);

    boolean existsByCuenta_IdAndUsuario(Integer id, String usuario);

}
