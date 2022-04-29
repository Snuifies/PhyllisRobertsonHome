package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.org.phyllis.robertson.home.entity.Role;

import java.util.Optional;

/**
 * @author snuif
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> findByRole(String role);

}
