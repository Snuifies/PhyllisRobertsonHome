package za.co.rhome.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.co.rhome.entity.AppUser;
import za.co.rhome.entity.PersistentLogin;

/**
 *
 * @author snuif
 */
@Repository
@Transactional
public interface PersistentLoginRepository extends JpaRepository<PersistentLogin, String> {

	@Query("SELECT AU FROM PersistentLogin AU WHERE AU.username = :username")
	Optional<PersistentLogin> findByUsername(@Param("username") String username);

}
