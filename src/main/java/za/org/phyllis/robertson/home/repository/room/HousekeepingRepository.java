
package za.org.phyllis.robertson.home.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.room.Housekeeping;

/**
 *
 * @author snuif
 */
@Repository

public interface HousekeepingRepository  extends JpaRepository<Housekeeping, Long>{
    
}
