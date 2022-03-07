package za.org.phyllis.robertson.home.repository.room;

import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.entity.room.Housekeeping;
import za.org.phyllis.robertson.home.entity.room.Room;

/**
 *
 * @author snuif
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HousekeepingRepositoryTest {

    @Resource
    HousekeepingRepository housekeepingRepository;
    @Resource
    RoomRepository roomRepository;

    @Test
    @Transactional
    public void whenAddHousekeepingsToRoomThenGetOkTest() {
	String roomNumber = "Room1";
	Room room = Room.builder().available(Boolean.TRUE).roomNumber(roomNumber).build();

	LocalDateTime testDateTime = LocalDateTime.now();
	String washingRemovedComment1 = "washingRemovedComment1";
	String washingReturnedComment1 = "washingReturnedComment1";
	String washingIssueComment1 = "washingIssueComment1";
	String roomCleanedComment1 = "roomCleanedComment1";
	String cleaningIssuesComment1 = "cleaningIssuesComment1";
	String monthlyDeepCleanComment1 = "monthlyDeepCleanComment1";
	String faultComplaintComment1 = "faultComplaintComment1";
	String faultResolvedComment1 = "faultResolvedComment1";

	Housekeeping housekeeping1 = Housekeeping.builder()
		.washingRemovedComment(washingRemovedComment1)
		.washingReturnedComment(washingReturnedComment1)
		.washingIssueComment(washingIssueComment1)
		.roomCleanedComment(roomCleanedComment1)
		.cleaningIssuesComment(cleaningIssuesComment1)
		.monthlyDeepCleanComment(monthlyDeepCleanComment1)
		.faultComplaintComment(faultComplaintComment1)
		.faultResolvedComment(faultResolvedComment1)
		.housekeepingDate(testDateTime)
		.washingRemovedDate(testDateTime)
		.washingReturnedDate(testDateTime)
		.monthlyDeepCleanDate(testDateTime)
		.roomCleanedDate(testDateTime)
		.faultComplaintDate(testDateTime)
		.faultResolvedDate(testDateTime)
		.build();
	room.addHousekeeping(housekeeping1);
	housekeeping1.setRoom(room);
	room = roomRepository.save(room);
	assertNotNull(room.getId());

	List<Housekeeping> housekeepings = housekeepingRepository.findByRoom(room);
	Assertions.assertFalse(housekeepings.isEmpty());
	Housekeeping entity = housekeepings.get(0);
	Assertions.assertEquals(washingRemovedComment1, entity.getWashingRemovedComment());
	Assertions.assertEquals(washingReturnedComment1, entity.getWashingReturnedComment());
	Assertions.assertEquals(washingIssueComment1, entity.getWashingIssueComment());
	Assertions.assertEquals(roomCleanedComment1, entity.getRoomCleanedComment());
	Assertions.assertEquals(cleaningIssuesComment1, entity.getCleaningIssuesComment());
	Assertions.assertEquals(monthlyDeepCleanComment1, entity.getMonthlyDeepCleanComment());
	Assertions.assertEquals(faultComplaintComment1, entity.getFaultComplaintComment());
	Assertions.assertEquals(faultResolvedComment1, entity.getFaultResolvedComment());
	Assertions.assertEquals(testDateTime, entity.getHousekeepingDate());
	Assertions.assertEquals(testDateTime, entity.getWashingRemovedDate());
	Assertions.assertEquals(testDateTime, entity.getWashingReturnedDate());
	Assertions.assertEquals(testDateTime, entity.getWashingReturnedDate());
	Assertions.assertEquals(testDateTime, entity.getMonthlyDeepCleanDate());
	Assertions.assertEquals(testDateTime, entity.getRoomCleanedDate());
	Assertions.assertEquals(testDateTime, entity.getFaultComplaintDate());
	Assertions.assertEquals(testDateTime, entity.getFaultResolvedDate());

	testDateTime = LocalDateTime.now();
	String washingRemovedComment2 = "washingRemovedComment2";
	String washingReturnedComment2 = "washingReturnedComment2";
	String washingIssueComment2 = "washingIssueComment2";
	String roomCleanedComment2 = "roomCleanedComment2";
	String cleaningIssuesComment2 = "cleaningIssuesComment2";
	String monthlyDeepCleanComment2 = "monthlyDeepCleanComment2";
	String faultComplaintComment2 = "faultComplaintComment2";
	String faultResolvedComment2 = "faultResolvedComment2";

	Housekeeping housekeeping2 = Housekeeping.builder()
		.washingRemovedComment(washingRemovedComment2)
		.washingReturnedComment(washingReturnedComment2)
		.washingIssueComment(washingIssueComment2)
		.roomCleanedComment(roomCleanedComment2)
		.cleaningIssuesComment(cleaningIssuesComment2)
		.monthlyDeepCleanComment(monthlyDeepCleanComment2)
		.faultComplaintComment(faultComplaintComment2)
		.faultResolvedComment(faultResolvedComment2)
		.housekeepingDate(testDateTime)
		.washingRemovedDate(testDateTime)
		.washingReturnedDate(testDateTime)
		.monthlyDeepCleanDate(testDateTime)
		.roomCleanedDate(testDateTime)
		.faultComplaintDate(testDateTime)
		.faultResolvedDate(testDateTime)
		.build();
	room.addHousekeeping(housekeeping2);
	housekeeping2.setRoom(room);
	room = roomRepository.save(room);
	housekeepings = housekeepingRepository.findByRoom(room);
	Assertions.assertFalse(housekeepings.isEmpty());
	entity = housekeepings.get(1);
	Assertions.assertEquals(washingRemovedComment2, entity.getWashingRemovedComment());
	Assertions.assertEquals(washingReturnedComment2, entity.getWashingReturnedComment());
	Assertions.assertEquals(washingIssueComment2, entity.getWashingIssueComment());
	Assertions.assertEquals(roomCleanedComment2, entity.getRoomCleanedComment());
	Assertions.assertEquals(cleaningIssuesComment2, entity.getCleaningIssuesComment());
	Assertions.assertEquals(monthlyDeepCleanComment2, entity.getMonthlyDeepCleanComment());
	Assertions.assertEquals(faultComplaintComment2, entity.getFaultComplaintComment());
	Assertions.assertEquals(faultResolvedComment2, entity.getFaultResolvedComment());
	Assertions.assertEquals(testDateTime, entity.getHousekeepingDate());
	Assertions.assertEquals(testDateTime, entity.getWashingRemovedDate());
	Assertions.assertEquals(testDateTime, entity.getWashingReturnedDate());
	Assertions.assertEquals(testDateTime, entity.getWashingReturnedDate());
	Assertions.assertEquals(testDateTime, entity.getMonthlyDeepCleanDate());
	Assertions.assertEquals(testDateTime, entity.getRoomCleanedDate());
	Assertions.assertEquals(testDateTime, entity.getFaultComplaintDate());
	Assertions.assertEquals(testDateTime, entity.getFaultResolvedDate());
	roomRepository.delete(room);
	Assertions.assertEquals(0, housekeepingRepository.findAll().size());
    }

}
