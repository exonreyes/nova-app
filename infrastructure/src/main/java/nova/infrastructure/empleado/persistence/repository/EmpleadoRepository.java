package nova.infrastructure.empleado.persistence.repository;

import nova.infrastructure.empleado.persistence.entity.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Integer> {
    <T> List<T> findByPuestoIdAndActivo(Integer id, Boolean estatus, Class<T> type);
}