package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.Resident;

import java.util.Optional;

/**
 * @author snuif
 */
@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    public Optional<Resident> findByIdNumber(String idNumber);

    public Optional<Resident> findByNickName(String nickName);

//    @Query(value = "SELECT T FROM RESIDENT T WHERE T.roomNumber = :roomNumber")
//    Optional<Resident> findByRoomNumber(@Param("roomNumber") String roomNumber);
}
