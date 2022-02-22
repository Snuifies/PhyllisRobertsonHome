package za.org.phyllis.robertson.home.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.entity.Condition;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionsRepositoryTest {

//    @Resource
//    ConditionRepository conditionRepository;
//    @Resource
//    ResidentRepository residentRepository;
//    @Resource
//    RoomRepository roomRepository;
//
//    @Test
//    public void givenCondition_whenSave_thenGetOk() {
//	Room room = Room.builder().roomNumber("Room 12").build();
//	roomRepository.save(room);
//
//	Resident resident = Resident.builder()
//		.idNumber("IDOFRESIDENT")
//		.name("PETER")
//		.nickName("PAN")
//		.room(room)
//		.build();
//
//	Condition condition = Condition.builder().condition("Fartiner").build();
//	resident.addCondition(condition);
//	residentRepository.save(resident);
//
//	List<Resident> residents = residentRepository.findAll();
//	Condition entity = residents.get(0).getConditions().get(0);
//	assertNotNull(entity);
//	assertEquals("Fartiner", entity.getCondition());
//    }

}
