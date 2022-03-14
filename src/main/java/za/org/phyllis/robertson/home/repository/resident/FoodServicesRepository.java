
package za.org.phyllis.robertson.home.repository.resident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.resident.FoodService;

/**
 *
 * @author snuif
 */
@Repository

public interface FoodServicesRepository  extends JpaRepository<FoodService, Long>{
    
}