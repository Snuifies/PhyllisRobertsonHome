package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.org.phyllis.robertson.home.service.RoomService;

@RestController
public class RoomResource {

    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public RoomResponse getAllRooms() {
        return RoomResponse.builder().rooms(roomService.findAllRooms()).build();
    }

}
