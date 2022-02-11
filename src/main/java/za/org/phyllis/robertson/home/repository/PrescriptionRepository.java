
package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Medical;
import za.org.phyllis.robertson.home.entity.Prescription;

/**
 *
 * @author snuif
 */
public interface PrescriptionRepository   extends JpaRepository<Prescription, Long>{
    
}
