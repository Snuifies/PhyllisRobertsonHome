package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import za.org.phyllis.robertson.home.entity.ResidentCondition;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;

import java.util.List;
import java.util.Optional;

/**
 * @author snuif
 */
@Repository
public interface ResidentConditionRepository extends JpaRepository<ResidentCondition, Long> {

    @Query(value = "select t from ResidentCondition t join t.resident r where r.idNumber = :idNumber")
    public List<ResidentCondition> findByResidentIdNumber(@Param("idNumber") String idNumber);
}
