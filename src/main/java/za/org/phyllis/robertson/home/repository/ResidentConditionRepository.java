package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.ResidentCondition;

import java.util.List;

/**
 * @author snuif
 */
@Repository
public interface ResidentConditionRepository extends JpaRepository<ResidentCondition, Long> {

    @Query(value = "select t from ResidentCondition t join t.resident r where r.idNumber = :idNumber")
     List<ResidentCondition> findByResidentIdNumber(@Param("idNumber") String idNumber);
}
