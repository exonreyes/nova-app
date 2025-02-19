package nova.infrastructure.empresa.persistence.repository;

import nova.infrastructure.empresa.persistence.entity.AreaSeguimientoModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AreaSeguimientoRepository extends JpaRepository<AreaSeguimientoModel, Integer> {
    List<AreaSeguimientoModel> findByEmpresa_Id(Integer id);

    @EntityGraph(attributePaths = {"reporteTickets"})
    @Query("select a from AreaSeguimientoModel a where a.empresa.id = ?1")
    List<AreaSeguimientoModel> obtenerPorEmpresaConReportes(Integer id);


    /**
     * Obtiene areas internas o externas con reportes asociados
     *
     * @param externo si es externo o no
     * @return lista de areas con reportes asociados
     */
    @Query("select a from AreaSeguimientoModel a where a.externo = ?1")
    @EntityGraph(attributePaths = {"reporteTickets"})
    List<AreaSeguimientoModel> obtenerConReportes(Boolean externo);

    List<AreaSeguimientoModel> findByExterno(Boolean externo);

    @EntityGraph(attributePaths = {"reporteTickets"})
    @Query("select a from AreaSeguimientoModel a")
    List<AreaSeguimientoModel> obtenerConReportes();


}