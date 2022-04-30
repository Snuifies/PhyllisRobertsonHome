package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;

import java.util.Optional;

/**
 * @author snuif
 */
public interface ResidentDailyCareRepository extends JpaRepository<ResidentDailyCare, Long> {

    public Optional<ResidentDailyCare> findByRoomNumber(String roomNumber);
}
