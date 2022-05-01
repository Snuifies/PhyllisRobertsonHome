package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;

import java.util.Optional;

/**
 * @author snuif
 */
@Repository
public interface ResidentDailyCareRepository extends JpaRepository<ResidentDailyCare, Long> {


}
