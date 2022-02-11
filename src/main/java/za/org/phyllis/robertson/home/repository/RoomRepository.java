
package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Medical;
import za.org.phyllis.robertson.home.entity.Prescription;
import za.org.phyllis.robertson.home.entity.Room;

/**
 *
 * @author snuif
 */
public interface RoomRepository   extends JpaRepository<Room, Long>{
    
}
