package za.org.phyllis.robertson.home.repository.room;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.entity.room.Room;

/**
 *
 * @author snuif
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {

    @Resource
    RoomRepository roomRepository;

    @org.junit.jupiter.api.Test
    void testRoomRepository() {
	String roomNumber = "Room1";
	Room room = Room.builder().available(Boolean.TRUE).roomNumber(roomNumber).build();
	room = roomRepository.saveAndFlush(room);
	assertNotNull(room.getId());
	assertNotNull(roomRepository.findByRoomNumber(roomNumber).get());
    }
}
