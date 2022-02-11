
package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Medical;

/**
 *
 * @author snuif
 */
public interface MedicalRepository  extends JpaRepository<Medical, Long>{
    
}
