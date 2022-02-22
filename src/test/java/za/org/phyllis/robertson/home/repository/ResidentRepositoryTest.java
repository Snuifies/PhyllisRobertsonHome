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

    @Test
    public void givenResidentWhenSaveThenGetOk() {
// given
	Room roomEntity =  roomRepository.saveAndFlush(Room.builder()
		.roomNumber(roomNumber)
		.available(Boolean.TRUE)
		.build());
	String idNumber = "ID_NUMBER";
	String name = "NAME";
	String nickName = "NICKNAME";
	Resident resident = Resident.builder()
		.idNumber(idNumber)
		.name(name)
		.nickName(nickName)
		.room(roomEntity)
		.build();

// when
	residentRepository.save(resident);
// then
	Optional<Resident> residentEntity = residentRepository.findByIdNumber(idNumber);
	assertTrue(residentEntity.isPresent());
	assertEquals(idNumber, residentEntity.get().getIdNumber());
	assertEquals(name, residentEntity.get().getName());
	assertEquals(nickName, residentEntity.get().getNickName());
	residentRepository.deleteAll();
	roomRepository.deleteAll();
    }

    @Test
    public void givenResidentWhenSaveThenGetByRoomIdOk() {
// given
	Room roomEntity =  roomRepository.saveAndFlush(Room.builder()
		.roomNumber(roomNumber)
		.available(Boolean.TRUE)
		.build());
	String idNumber = "ID_NUMBER";
	String name = "NAME";
	String nickName = "NICKNAME";
	Resident resident = Resident.builder()
		.idNumber(idNumber)
		.name(name)
		.nickName(nickName)
		.room(roomEntity)
		.build();
// when
	residentRepository.save(resident);
// then
	Optional<Resident> residentEntity = residentRepository.findByRoom(roomEntity.getId());
	assertTrue(residentEntity.isPresent());
	assertEquals(idNumber, residentEntity.get().getIdNumber());
	assertEquals(name, residentEntity.get().getName());
	assertEquals(nickName, residentEntity.get().getNickName());
	assertEquals(roomEntity.getId(), residentEntity.get().getRoom().getId());
	residentRepository.deleteAll();
	roomRepository.deleteAll();
    }
}
