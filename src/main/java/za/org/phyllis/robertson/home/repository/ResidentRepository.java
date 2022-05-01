package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.Resident;

import java.util.Optional;

/**
 * @author snuif
 */
@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    Optional<Resident> findByIdNumber(String idNumber);

    Optional<Resident> findByNickName(String nickName);

}
