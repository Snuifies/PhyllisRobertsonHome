package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.ResidentCondition;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;

import java.util.List;
import java.util.Optional;

/**
 * @author snuif
 */
@Repository
public interface ResidentConditionRepository extends JpaRepository<ResidentCondition, Long> {

    public List<ResidentCondition> findByRoomNumber(String roomNumber);
}
