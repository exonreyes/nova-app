package nova.empresa.repository;

import nova.empresa.model.UnidadModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnidadJpaRepository extends JpaRepository<UnidadModel, Integer> {

    <T> Optional<T> findById(Integer integer, Class<T> type);

    <T> List<T> findBy(Class<T> type);

    <T> List<T> findBySupervisor_Id(Integer id, Class<T> type);

    <T> List<T> findByZona_Id(Integer id, Class<T> type);


}