package nova.empresa.repository;

import nova.empresa.model.view.EmpleadoGenerales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EmpleadoGeneralesJpaRepository extends JpaRepository<EmpleadoGenerales, Integer>, JpaSpecificationExecutor<EmpleadoGenerales> {
    Optional<EmpleadoGenerales> findByCodigoEmpleado(String codigoEmpleado);

}