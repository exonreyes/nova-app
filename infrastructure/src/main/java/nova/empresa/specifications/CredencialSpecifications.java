package nova.empresa.specifications;

import jakarta.persistence.criteria.Predicate;
import nova.cuenta.command.FiltroCuentaCmd;
import nova.cuenta.model.CredencialModel;
import org.springframework.data.jpa.domain.Specification;

public class CredencialSpecifications {

    public static Specification<CredencialModel> conFiltro(FiltroCuentaCmd filtro) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (filtro.getIdUnidad() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("unidad").get("id"), filtro.getIdUnidad()));
            }

            if (filtro.getIdDepartamento() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("departamento").get("id"), filtro.getIdDepartamento()));
            }

            if (filtro.getIdProveedor() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("cuenta").get("id"), filtro.getIdProveedor()));
            }

            return predicate;
        };
    }
}
