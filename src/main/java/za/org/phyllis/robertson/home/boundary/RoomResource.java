package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    @Autowired
    RoomService roomService;

    @GetMapping
    public RoomResponse getAllRooms() {
        return RoomResponse.builder().rooms(roomService.findAllRooms()).build();
    }

    @GetMapping("/{roomNumber}")
    public RoomResponse getRoom(@PathVariable("roomNumber") String roomNumber) {
        try {
            return RoomResponse.builder().room(roomService.findByRoomNumber(roomNumber)).build();
        } catch (ResourceNotFoundException ex) {
            return RoomResponse.builder().message(ex.getMessage()).build();
        }
    }

    @PutMapping("/{description}")
    public RoomResponse addRoom(@PathVariable("roomNumber") String roomNumber, @PathVariable("description") String description) {
        try {
            return RoomResponse.builder().room(roomService.addRoom(roomNumber, description)).build();
        } catch (ResourceAlreadyExistsException e) {
            return RoomResponse.builder().message(e.getMessage()).build();
        }
    }

    @PatchMapping("/{roomNumber}/{description}")
    public RoomResponse updateRoomDescription(@PathVariable("roomNumber") String roomNumber, @PathVariable("description") String description) {
        try {
            return RoomResponse.builder().room(roomService.updateRoomDescription(roomNumber, description)).build();
        } catch (ResourceNotFoundException e) {
            return RoomResponse.builder().message(e.getMessage()).build();
        }
    }
}
