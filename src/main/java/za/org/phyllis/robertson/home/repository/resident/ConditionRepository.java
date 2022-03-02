package za.org.phyllis.robertson.home.repository.resident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.resident.Condition;

/**
 *
 * @author snuif
 */
@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {

}
