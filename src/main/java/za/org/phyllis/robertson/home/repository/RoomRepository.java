package za.org.phyllis.robertson.home.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.Medical;
import za.org.phyllis.robertson.home.entity.Prescription;
import za.org.phyllis.robertson.home.entity.Room;

/**
 *
 * @author snuif
 */
@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomNumber(String roomNumber);

}
