package za.org.phyllis.robertson.home.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Role;

/**
 * @author snuif
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> findByRole(String role);

}
