package za.org.phyllis.robertson.home.repository;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResidentRepositoryTest {

    @Resource
    RoomRepository roomRepository;
    @Resource
    ResidentRepository residentRepository;
    static String roomNumber = "Room 12";

    @BeforeEach
    public void saveRoom() {
	Room room = Room.builder()
		.roomNumber(roomNumber)
		.available(Boolean.TRUE)
		.build();
	roomRepository.saveAndFlush(room);
    }

    @Test
    public void givenResidentWhenSaveThenGetOk() {
// given
	Optional<Room> roomEntity = roomRepository.findByRoomNumber(roomNumber);

	assertTrue(roomEntity.isPresent());
	String idNumber = "ID_NUMBER";
	String name = "NAME";
	String nickName = "NICKNAME";
	Resident resident = Resident.builder()
		.idNumber(idNumber)
		.name(name)
		.nickName(nickName)
		.room(roomEntity.get())
		.build();

// when
	residentRepository.save(resident);
// then
	Optional<Resident> residentEntity = residentRepository.findByIdNumber(idNumber);
	assertTrue(residentEntity.isPresent());
	assertEquals(idNumber, residentEntity.get().getIdNumber());
	assertEquals(name, residentEntity.get().getName());
	assertEquals(nickName, residentEntity.get().getNickName());
	residentRepository.delete(resident);
	roomRepository.delete(roomEntity.get());
    }

    @Test
    public void givenResidentWhenSaveThenGetRoomOk() {
// given
	Optional<Room> roomEntity = roomRepository.findByRoomNumber(roomNumber);
// when
	assertTrue(roomEntity.isPresent());
	String idNumber = "ID_NUMBER";
	String name = "NAME";
	String nickName = "NICKNAME";
	Resident resident = Resident.builder()
		.idNumber(idNumber)
		.name(name)
		.nickName(nickName)
		.room(roomEntity.get())
		.build();
	residentRepository.save(resident);
// then
	Optional<Resident> residentEntity = residentRepository.findByRoom(roomEntity.get().getId());
	assertTrue(residentEntity.isPresent());
	assertEquals(idNumber, residentEntity.get().getIdNumber());
	assertEquals(name, residentEntity.get().getName());
	assertEquals(nickName, residentEntity.get().getNickName());
	assertEquals(roomEntity.get().getId(), residentEntity.get().getRoom().getId());
	residentRepository.delete(resident);
	roomRepository.delete(roomEntity.get());
    }

    @Test
    public void givenResidentWhenSaveThenGetOnlyOneRoomObjectOk() {
// given
	Optional<Room> roomEntity = roomRepository.findByRoomNumber(roomNumber);
// when
	assertTrue(roomEntity.isPresent());
	String idNumber = "ID_NUMBER";
	String name = "NAME";
	String nickName = "NICKNAME";
	Resident resident = Resident.builder()
		.idNumber(idNumber)
		.name(name)
		.nickName(nickName)
		.room(roomEntity.get())
		.build();
	residentRepository.save(resident);
// then
	List<Room> roomEntities = roomRepository.findAll();
	assertEquals(1, roomEntities.size());

	List<Resident> residents = residentRepository.findAll();
	assertEquals(1, residents.size());
	residentRepository.delete(resident);
	roomRepository.delete(roomEntity.get());
    }
}
