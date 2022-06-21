package za.co.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import za.co.phyllis.robertson.home.entity.Resident;

/**
 * @author snuif
 */
@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

	Optional<Resident> findByIdNumber(String idNumber);

	Optional<Resident> findByNickName(String nickName);

	@Query(value = "select t from Resident t join t.room r where r.roomNumber = :roomNumber")
	Optional<Resident> findByRoomNumber(String roomNumber);

}
