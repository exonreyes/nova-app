package nova.ticket.repository;

import nova.ticket.model.HistorialTicketModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialJpaRepository extends JpaRepository<HistorialTicketModel, Integer> {
    <T> List<T> findByIdTicket(Integer ticket, Class<T> type, Sort orderBy);
}