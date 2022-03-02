package za.org.phyllis.robertson.home.resource;

import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.entity.resident.Resident;
import za.org.phyllis.robertson.home.entity.room.Room;
import za.org.phyllis.robertson.home.repository.resident.ResidentRepository;
import za.org.phyllis.robertson.home.repository.room.RoomRepository;

/**
 *
 * @author snuif
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResidentResourceTest {
//
//    @Autowired
//    ResidentResource resource;
//    @Resource
//    ResidentRepository residentRepository;
//    @Resource
//    RoomRepository roomRepository;
//
//    @Test
//    public void ResidentResourceGetAllResidentsTest() {
//        Room roomModel = Room.builder().roomNumber("Room 12").build();
//        Room roomEntity = roomRepository.save(roomModel);
//
//        Resident residentModel = Resident.builder().room(roomEntity).build();
//        residentRepository.save(residentModel);
//        List<Resident> residentEntities = residentRepository.findAll();
//        assertNotNull(residentEntities);
//        assertNotNull(residentEntities.get(0).getId());
//        List<Resident> residents = resource.getAllResidents().getBody();
//        Room roomOutput = residents.get(0).getRoom();
//        assertEquals("Room 12", roomOutput.getRoomNumber());
//    }

}
