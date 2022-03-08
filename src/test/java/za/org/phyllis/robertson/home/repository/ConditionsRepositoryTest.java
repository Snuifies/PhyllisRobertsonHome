package za.org.phyllis.robertson.home.repository;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
