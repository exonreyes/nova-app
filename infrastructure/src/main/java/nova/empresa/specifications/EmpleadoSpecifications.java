package nova.empresa.specifications;

import jakarta.persistence.criteria.Predicate;
import nova.empresa.command.EmpleadoFiltroCommand;
import nova.empresa.model.view.EmpleadoGenerales;
import org.springframework.data.jpa.domain.Specification;

public class EmpleadoSpecifications {

    public static Specification<EmpleadoGenerales> filtro(EmpleadoFiltroCommand filtro) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (filtro.idPuesto() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("idPuesto"), filtro.idPuesto()));
            }

            if (filtro.estatus() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("estatus"), filtro.estatus()));
            }
            if (filtro.idUnidad() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("idUnidad"), filtro.idUnidad()));
            }
            return predicate;
        };
    }
}