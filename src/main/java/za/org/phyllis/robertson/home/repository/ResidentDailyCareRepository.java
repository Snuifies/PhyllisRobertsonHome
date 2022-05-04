package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;

/**
 * @author snuif
 */
@Repository
public interface ResidentDailyCareRepository extends JpaRepository<ResidentDailyCare, Long> {


}
