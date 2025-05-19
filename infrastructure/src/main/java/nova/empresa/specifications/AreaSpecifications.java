package nova.empresa.specifications;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import nova.empresa.command.AreaFiltro;
import nova.empresa.model.AreaModel;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene especificaciones para construir consultas dinámicas
 * sobre la entidad {@link AreaModel} utilizando Spring Data JPA Specifications.
 * <p>
 * Esta clase permite aplicar filtros condicionales opcionales como parte
 * de una búsqueda flexible, sin necesidad de escribir queries manualmente.
 */
public class AreaSpecifications {

    // Constantes para evitar errores por refactor o cambios de nombre
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_EXTERNO = "externo";
    private static final String CAMPO_OBTENER_REPORTES = "reportes";

    /**
     * Construye una Specification dinámica para {@link AreaModel}, basada
     * en los campos no nulos del filtro proporcionado.
     *
     * @param filtro objeto con los criterios de filtrado (pueden ser nulos)
     * @return una Specification que puede ser usada con findAll(spec)
     */
    public static Specification<AreaModel> conFiltro(AreaFiltro filtro) {
        return (root, query, cb) -> {
            // Si no se proporciona filtro, no aplicar condiciones (retorna todo)
            if (filtro == null) {
                return cb.conjunction();
            }

            // IMPORTANTE: evitar múltiples ejecuciones de count(*) con fetch
            if (AreaModel.class.equals(query.getResultType()) && Boolean.TRUE.equals(filtro.getReportes())) {
                // Aplica join fetch solo si se está ejecutando una consulta select (no count)
                root.fetch(CAMPO_OBTENER_REPORTES, JoinType.LEFT);
                // Si no haces esto, Hibernate lanzará excepción en count queries
                query.distinct(true);
            }

            List<Predicate> predicates = new ArrayList<>();

            if (filtro.getId() != null) {
                predicates.add(cb.equal(root.get(CAMPO_ID), filtro.getId()));
            }

            if (filtro.getExterno() != null) {
                predicates.add(cb.equal(root.get(CAMPO_EXTERNO), filtro.getExterno()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
