
package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.DailyCare;

/**
 *
 * @author snuif
 */
public interface DailyCareRepository extends JpaRepository<DailyCare, Long>{
    
}
