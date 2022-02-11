
package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Housekeeping;

/**
 *
 * @author snuif
 */
public interface HousekeepingRepository  extends JpaRepository<Housekeeping, Long>{
    
}
