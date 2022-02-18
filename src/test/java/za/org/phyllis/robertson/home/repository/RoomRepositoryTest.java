package za.org.phyllis.robertson.home.repository;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {

    @Resource
    RoomRepository roomRepository;
    @Resource
    ResidentRepository residentRepository;

    @Test
    public void givenRoomNumberWhenSaveThenGetRoom() {
	String roomNumber = "Room 12";
	Room model = Room.builder().roomNumber(roomNumber).build();
	roomRepository.save(model);
	Optional<Room> entity = roomRepository.findByRoomNumber(roomNumber);
	assertNotNull(entity.get());
	assertEquals(roomNumber, entity.get().getRoomNumber());
    }

    @Test
    public void givenIdWhenSaveThenGetRoom() {
	String roomNumber = "Room 12";
	Room model = Room.builder().roomNumber(roomNumber).build();
	roomRepository.save(model);
	Optional<Room> entity = roomRepository.findById(1L);
	assertNotNull(entity.get());
	assertEquals(roomNumber, entity.get().getRoomNumber());
    }
}
