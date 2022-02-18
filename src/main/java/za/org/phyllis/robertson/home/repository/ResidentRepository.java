package za.org.phyllis.robertson.home.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.Resident;

/**
 *
 * @author snuif
 */
@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    Optional<Resident> findByName(String name);

    Optional<Resident> findByIdNumber(String idNumber);

    Optional<Resident> findByNickName(String nickName);

    @Query(value = "select res from Resident res where res.room.id = :roomId")
    Optional<Resident> findByRoom(@Param("roomId") long roomId);
}
