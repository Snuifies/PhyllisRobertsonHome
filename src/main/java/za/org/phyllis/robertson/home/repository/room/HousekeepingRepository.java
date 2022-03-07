
package za.org.phyllis.robertson.home.repository.room;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.room.Housekeeping;
import za.org.phyllis.robertson.home.entity.room.Room;

/**
 *
 * @author snuif
 */
@Repository

public interface HousekeepingRepository  extends JpaRepository<Housekeeping, Long>{

    List<Housekeeping> findByRoom(Room room);
    
}
