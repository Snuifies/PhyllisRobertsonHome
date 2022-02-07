package za.org.phyllis.robertson.home.repository;

import za.org.phyllis.robertson.home.entity.Role;
import za.org.phyllis.robertson.home.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(UserRole name);
}
