package za.co.phyllis.robertson.home.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.co.phyllis.robertson.home.entity.AppRole;

@Repository
@Transactional
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

	@Query(value = "SELECT AR.ROLE_NAME FROM APP_ROLE AR JOIN USER_ROLE UR ON UR.ROLE_ID = AR.ROLE_ID WHERE UR.USER_ID = :userId", nativeQuery = true)
	List<String> findByUserId(@Param("userId") Long userId);

}
