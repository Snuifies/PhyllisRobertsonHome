package za.co.phyllis.robertson.home.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.phyllis.robertson.home.service.RoomService;

@RestController
@RequestMapping("/rest/rooms")
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
		} catch (Exception ex) {
			return RoomResponse.builder().message(ex.getMessage()).build();
		}
	}

	@PutMapping("/{roomNumber}/{description}")
	public RoomResponse addRoom(@PathVariable("roomNumber") String roomNumber, @PathVariable("description") String description) {
		try {
			return RoomResponse.builder().room(roomService.addRoom(roomNumber, description)).build();
		} catch (Exception e) {
			return RoomResponse.builder().message(e.getMessage()).build();
		}
	}

	@PatchMapping("/{roomNumber}/{description}")
	public RoomResponse updateRoomDescription(@PathVariable("roomNumber") String roomNumber, @PathVariable("description") String description) {
		try {
			return RoomResponse.builder().room(roomService.updateRoomDescription(roomNumber, description)).build();
		} catch (Exception e) {
			return RoomResponse.builder().message(e.getMessage()).build();
		}
	}
}
