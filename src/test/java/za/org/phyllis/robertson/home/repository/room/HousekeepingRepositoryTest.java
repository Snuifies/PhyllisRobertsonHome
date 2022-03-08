package za.org.phyllis.robertson.home.repository.room;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
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

    static String roomNumber = "Room1";
    Room room;

    static LocalDateTime testDateTime = LocalDateTime.now();

    @Test
    public void contextLoads() {
	assertNotNull(housekeepingRepository);
	assertNotNull(roomRepository);
    }

    @BeforeEach
    void initData() {
	room = Room.builder().available(Boolean.TRUE).roomNumber(roomNumber).build();
	room = roomRepository.saveAndFlush(room);
	assertNotNull(room.getId());
    }

    @Test
    @Transactional
    public void whenAddHousekeepingsToRoomThenGetOkTest() {
	addHousekeepingtoRoom("washingRemovedComment1",
		"washingReturnedComment1",
		"washingIssueComment1",
		"roomCleanedComment1",
		"cleaningIssuesComment1",
		"monthlyDeepCleanComment1",
		"faultComplaintComment1",
		"faultResolvedComment1",
		testDateTime);

	List<Housekeeping> housekeepings = housekeepingRepository.findByRoom(room);
	assertFalse(housekeepings.isEmpty());
	Housekeeping entity = housekeepings.get(0);
	assertEquals("washingRemovedComment1", entity.getWashingRemovedComment());
	assertEquals("washingReturnedComment1", entity.getWashingReturnedComment());
	assertEquals("washingIssueComment1", entity.getWashingIssueComment());
	assertEquals("roomCleanedComment1", entity.getRoomCleanedComment());
	assertEquals("cleaningIssuesComment1", entity.getCleaningIssuesComment());
	assertEquals("monthlyDeepCleanComment1", entity.getMonthlyDeepCleanComment());
	assertEquals("faultComplaintComment1", entity.getFaultComplaintComment());
	assertEquals("faultResolvedComment1", entity.getFaultResolvedComment());
	assertEquals(testDateTime, entity.getHousekeepingDate());
	assertEquals(testDateTime, entity.getWashingRemovedDate());
	assertEquals(testDateTime, entity.getWashingReturnedDate());
	assertEquals(testDateTime, entity.getWashingReturnedDate());
	assertEquals(testDateTime, entity.getMonthlyDeepCleanDate());
	assertEquals(testDateTime, entity.getRoomCleanedDate());
	assertEquals(testDateTime, entity.getFaultComplaintDate());
	assertEquals(testDateTime, entity.getFaultResolvedDate());
    }

    @Test
    @Transactional
    public void whenAddAnotherHousekeepingsToRoomThenGetOkTest() {
	addHousekeepingtoRoom("washingRemovedComment1",
		"washingReturnedComment1",
		"washingIssueComment1",
		"roomCleanedComment1",
		"cleaningIssuesComment1",
		"monthlyDeepCleanComment1",
		"faultComplaintComment1",
		"faultResolvedComment1",
		testDateTime);

	addHousekeepingtoRoom("washingRemovedComment2",
		"washingReturnedComment2",
		"washingIssueComment2",
		"roomCleanedComment2",
		"cleaningIssuesComment2",
		"monthlyDeepCleanComment2",
		"faultComplaintComment2",
		"faultResolvedComment2",
		testDateTime);

	List<Housekeeping> housekeepings = housekeepingRepository.findByRoom(room);
	assertFalse(housekeepings.isEmpty());
	Housekeeping entity = housekeepings.get(1);
	assertEquals("washingRemovedComment2", entity.getWashingRemovedComment());
	assertEquals("washingReturnedComment2", entity.getWashingReturnedComment());
	assertEquals("washingIssueComment2", entity.getWashingIssueComment());
	assertEquals("roomCleanedComment2", entity.getRoomCleanedComment());
	assertEquals("cleaningIssuesComment2", entity.getCleaningIssuesComment());
	assertEquals("monthlyDeepCleanComment2", entity.getMonthlyDeepCleanComment());
	assertEquals("faultComplaintComment2", entity.getFaultComplaintComment());
	assertEquals("faultResolvedComment2", entity.getFaultResolvedComment());
	assertEquals(testDateTime, entity.getHousekeepingDate());
	assertEquals(testDateTime, entity.getWashingRemovedDate());
	assertEquals(testDateTime, entity.getWashingReturnedDate());
	assertEquals(testDateTime, entity.getWashingReturnedDate());
	assertEquals(testDateTime, entity.getMonthlyDeepCleanDate());
	assertEquals(testDateTime, entity.getRoomCleanedDate());
	assertEquals(testDateTime, entity.getFaultComplaintDate());
	assertEquals(testDateTime, entity.getFaultResolvedDate());
    }

    @Test
    @Transactional
    public void whenUpdateHousekeepingThenGetOkTest() {
	addHousekeepingtoRoom("washingRemovedComment2",
		"washingReturnedComment2",
		"washingIssueComment2",
		"roomCleanedComment2",
		"cleaningIssuesComment2",
		"monthlyDeepCleanComment2",
		"faultComplaintComment2",
		"faultResolvedComment2",
		testDateTime);
	List<Housekeeping> housekeepings = housekeepingRepository.findByRoom(room);
	assertFalse(housekeepings.isEmpty());
	Housekeeping entity = housekeepings.get(0);
	entity.setCleaningIssuesComment("cleaningIssuesComment3");
	entity.setMonthlyDeepCleanComment("monthlyDeepCleanComment3");
	entity.setFaultComplaintComment("faultComplaintComment3");
	entity.setFaultResolvedComment("faultResolvedComment3");
	housekeepingRepository.save(entity);
	Optional<Housekeeping> housekeeping = housekeepingRepository.findById(entity.getId());
	assertTrue(housekeeping.isPresent());
	entity = housekeeping.get();
	assertEquals("cleaningIssuesComment3", entity.getCleaningIssuesComment());
	assertEquals("monthlyDeepCleanComment3", entity.getMonthlyDeepCleanComment());
	assertEquals("faultComplaintComment3", entity.getFaultComplaintComment());
	assertEquals("faultResolvedComment3", entity.getFaultResolvedComment());
	assertEquals(room, entity.getRoom());
    }

    private void addHousekeepingtoRoom(String washingRemovedComment,
	    String washingReturnedComment,
	    String washingIssueComment,
	    String roomCleanedComment,
	    String cleaningIssuesComment,
	    String monthlyDeepCleanComment,
	    String faultComplaintComment,
	    String faultResolvedComment,
	    LocalDateTime testDateTime) {
	Housekeeping housekeeping = Housekeeping.builder()
		.washingRemovedComment(washingRemovedComment)
		.washingReturnedComment(washingReturnedComment)
		.washingIssueComment(washingIssueComment)
		.roomCleanedComment(roomCleanedComment)
		.cleaningIssuesComment(cleaningIssuesComment)
		.monthlyDeepCleanComment(monthlyDeepCleanComment)
		.faultComplaintComment(faultComplaintComment)
		.faultResolvedComment(faultResolvedComment)
		.housekeepingDate(testDateTime)
		.washingRemovedDate(testDateTime)
		.washingReturnedDate(testDateTime)
		.monthlyDeepCleanDate(testDateTime)
		.roomCleanedDate(testDateTime)
		.faultComplaintDate(testDateTime)
		.faultResolvedDate(testDateTime)
		.build();
	room.addHousekeeping(housekeeping);
	housekeeping.setRoom(room);
	room = roomRepository.save(room);
    }
}
