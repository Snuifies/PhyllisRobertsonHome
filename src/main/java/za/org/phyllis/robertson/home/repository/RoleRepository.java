package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.User;
import za.org.phyllis.robertson.home.entity.Role;

/**
 *
 * @author snuif
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
