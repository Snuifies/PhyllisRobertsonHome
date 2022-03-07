package za.org.phyllis.robertson.home.repository.room;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.room.Room;

/**
 *
 * @author snuif
 */
@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomNumber(String roomNumber);

}
