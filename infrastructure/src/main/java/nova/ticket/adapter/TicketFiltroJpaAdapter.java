package nova.ticket.adapter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import nova.commons.Data;
import nova.ticket.Ticket;
import nova.ticket.command.FiltroGeneralesTicketCommand;
import nova.ticket.mapper.TicketMapper;
import nova.ticket.model.TicketModel;
import nova.ticket.model.query.TicketInfoQuery;
import nova.ticket.repository.TicketFiltroJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TicketFiltroJpaAdapter implements TicketFiltroJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Data<List<Ticket>> obtenerGenerales(FiltroGeneralesTicketCommand filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TicketInfoQuery> cq = cb.createQuery(TicketInfoQuery.class);
        Root<TicketModel> ticket = cq.from(TicketModel.class);

        Join<Object, Object> unidadJoin = ticket.join("unidad", JoinType.INNER);
        Join<Object, Object> reporteJoin = ticket.join("reporte", JoinType.INNER);
        Join<Object, Object> estatusJoin = ticket.join("estatus", JoinType.INNER);

        cq.select(cb.construct(
                TicketInfoQuery.class,
                ticket.get("id"),
                unidadJoin.get("id"),
                unidadJoin.get("clave"),
                unidadJoin.get("nombre"),
                estatusJoin.get("id"),
                estatusJoin.get("nombre"),
                reporteJoin.get("id"),
                reporteJoin.get("nombre"),
                reporteJoin.get("area").get("id"),
                reporteJoin.get("area").get("nombre"),
                ticket.get("folio"),
                ticket.get("agente"),
                ticket.get("creado"),
                ticket.get("publicar"),
                ticket.get("actualizado")
        ));

        List<Predicate> predicates = buildPredicates(cb, ticket, unidadJoin, reporteJoin, filtro);
        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(ticket.get("creado")));

        int pagina = filtro.getPagina() != null ? filtro.getPagina() : 0;
        int filas = filtro.getFilas() != null ? filtro.getFilas() : 10;

        List<Ticket> resultList = entityManager.createQuery(cq)
                .setFirstResult(pagina * filas)
                .setMaxResults(filas)
                .getResultList()
                .stream()
                .map(TicketMapper::convertirGenerales)
                .toList();

        Long totalResults = countByFiltro(filtro);
        Page<Ticket> page = new PageImpl<>(resultList, PageRequest.of(pagina, filas), totalResults);

        return Data.paginated(page.getContent(), pagina, page.getNumberOfElements(), page.getTotalElements(), page.getTotalPages());
    }

    private Long countByFiltro(FiltroGeneralesTicketCommand filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TicketModel> ticket = cq.from(TicketModel.class);

        List<Predicate> predicates = buildPredicates(cb, ticket, ticket.join("unidad"), ticket.join("reporte"), filtro);

        cq.select(cb.count(ticket));
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getSingleResult();
    }

    /**
     * Genera los predicados reutilizables para Criteria API.
     */
    private List<Predicate> buildPredicates(CriteriaBuilder cb, Root<TicketModel> ticket,
                                            Join<Object, Object> unidadJoin,
                                            Join<Object, Object> reporteJoin,
                                            FiltroGeneralesTicketCommand filtro) {

        List<Predicate> predicates = new ArrayList<>();

        if (filtro.getUnidadId() != null) {
            predicates.add(cb.equal(unidadJoin.get("id"), filtro.getUnidadId()));
        }

        if (filtro.getSupervisorId() != null) {
            predicates.add(cb.equal(unidadJoin.get("supervisor").get("id"), filtro.getSupervisorId()));
        }

        if (filtro.getZonaId() != null) {
            predicates.add(cb.equal(unidadJoin.get("zona").get("id"), filtro.getZonaId()));
        }

        if (filtro.getEstatusId() != null) {
            predicates.add(cb.equal(ticket.get("estatus").get("id"), filtro.getEstatusId()));
        }

        if (filtro.getPublicar() != null) {
            predicates.add(cb.equal(ticket.get("publicar"), filtro.getPublicar()));
        }

        if (filtro.getAreaId() != null) {
            predicates.add(cb.equal(reporteJoin.get("area").get("id"), filtro.getAreaId()));
        }

        if (filtro.getCreadoDesde() != null) {
            predicates.add(cb.greaterThanOrEqualTo(ticket.get("creado"), filtro.getCreadoDesde()));
        }

        if (filtro.getCreadoHasta() != null) {
            predicates.add(cb.lessThanOrEqualTo(ticket.get("creado"), filtro.getCreadoHasta()));
        }

        if (filtro.getFolio() != null) {
            predicates.add(cb.like(ticket.get("folio"), "%" + filtro.getFolio() + "%"));
        }

        return predicates;
    }
}
