
package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.Medical;
import za.org.phyllis.robertson.home.entity.Prescription;

/**
 *
 * @author snuif
 */
@Repository

public interface PrescriptionRepository   extends JpaRepository<Prescription, Long>{
    
}
