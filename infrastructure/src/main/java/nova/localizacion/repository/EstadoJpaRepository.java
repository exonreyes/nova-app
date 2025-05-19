package nova.localizacion.repository;

import nova.localizacion.model.EstadoModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoJpaRepository extends JpaRepository<EstadoModel, String> {
    @EntityGraph(attributePaths = {"zonas"})
    @Query("select e from EstadoModel e")
    List<EstadoModel> obtenerEstadosConZonas();

}