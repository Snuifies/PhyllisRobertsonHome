package za.org.phyllis.robertson.home.repository;

import java.util.List;
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
    public void givenCondition_whenSave_thenGetOk() {
	Room model = Room.builder().roomNumber("Room 12").build();
	roomRepository.save(model);

	Resident resident = Resident.builder().idNumber("621220502704")
		.name("Marius").nickName("Snuifies").room(model).build();
	residentRepository.save(resident);

	List<Room> entities = roomRepository.findAll();
	assertNotNull(entities);
	assertEquals("Marius", entities.get(0).getResident().getName());
    }

}
