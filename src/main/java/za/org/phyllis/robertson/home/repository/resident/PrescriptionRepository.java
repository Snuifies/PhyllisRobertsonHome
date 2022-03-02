
package za.org.phyllis.robertson.home.repository.resident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.resident.Medical;
import za.org.phyllis.robertson.home.entity.resident.Prescription;

/**
 *
 * @author snuif
 */
@Repository

public interface PrescriptionRepository   extends JpaRepository<Prescription, Long>{
    
}
