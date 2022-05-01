package za.org.phyllis.robertson.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.Room;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "select t from Room t where t.roomNumber = :roomNumber")
    Optional<Room> findByRoomNumber(String roomNumber);
}
