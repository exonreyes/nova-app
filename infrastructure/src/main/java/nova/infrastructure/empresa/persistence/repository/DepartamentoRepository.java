package nova.infrastructure.empresa.persistence.repository;

import nova.infrastructure.empresa.persistence.entity.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Integer> {
    List<DepartamentoModel> findByEmpresa_Id(Integer id);

}