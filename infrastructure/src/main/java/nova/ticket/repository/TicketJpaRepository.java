package nova.ticket.repository;

import nova.ticket.model.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TicketJpaRepository extends JpaRepository<TicketModel, Integer>, JpaSpecificationExecutor<TicketModel> {
    <T> Optional<T> findByFolio(String integer, Class<T> type);

    <T> Optional<T> findById(Integer integer, Class<T> type);

    @Transactional
    @Modifying
    @Query("update TicketModel t set t.publicar = ?1 where t.id = ?2")
    void updatePublicarById(Boolean publicar, Integer id);

    @Transactional
    @Modifying
    @Query("update TicketModel t set t.estatus.id = ?1 where t.id = ?2")
    void updateEstatusById(Integer estatusId, Integer id);

    boolean existsByFolio(String folio);

}