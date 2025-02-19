package nova.infrastructure.empresa.persistence.repository;

import nova.infrastructure.empresa.persistence.entity.UnidadNegocioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnidadNegocioRepository extends JpaRepository<UnidadNegocioModel, Integer> {
    <T> List<T> findByEmpresaId(Integer IDEmpresa, Class<T> type);

    <T> List<T> findByZonaId(Integer IDZona, Class<T> type);

    <T> List<T> findBySupervisorId(Long id, Class<T> type);

    <T> Optional<T> findById(Integer integer, Class<T> type);
}