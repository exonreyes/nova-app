package nova.infrastructure.localizacion.persistence.repository;

import nova.infrastructure.localizacion.persistence.entity.EntidadFederativaModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EntidadFederativaRepository extends JpaRepository<EntidadFederativaModel, String> {

    @EntityGraph(attributePaths = {"zonaFederativas"})
    @Query("select e from EntidadFederativaModel e")
    List<EntidadFederativaModel> obtenerConZonas();

    @EntityGraph(attributePaths = {"zonaFederativas"})
    @Query("select e from EntidadFederativaModel e where e.clave = ?1")
    Optional<EntidadFederativaModel> obtenerZonas(String id);

}