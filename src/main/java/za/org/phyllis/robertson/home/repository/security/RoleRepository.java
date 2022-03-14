package za.org.phyllis.robertson.home.repository.security;

import za.org.phyllis.robertson.home.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(String role);

    void deleteByRole(String role);
}
