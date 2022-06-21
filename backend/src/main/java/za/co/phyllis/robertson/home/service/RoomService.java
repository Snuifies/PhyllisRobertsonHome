package za.co.phyllis.robertson.home.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.phyllis.robertson.home.entity.Room;
import za.co.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.co.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.co.phyllis.robertson.home.model.RoomDO;
import za.co.phyllis.robertson.home.repository.ResidentRepository;
import za.co.phyllis.robertson.home.repository.RoomRepository;

@Log4j2
@Service
public class RoomService {

	RoomRepository roomRepository;
	ResidentRepository residentRepository;

	@Autowired
	public RoomService(RoomRepository roomRepository, ResidentRepository residentRepository) {
		this.residentRepository = residentRepository;
		this.roomRepository = roomRepository;
	}

	@Transactional
	public List<RoomDO> findAllRooms() {
		List<Room> rooms = roomRepository.findAll();
		return rooms.stream().map(RoomDO::new).collect(Collectors.toList());
	}

	@Transactional
	public RoomDO findByRoomNumber(String roomNumber) throws ResourceNotFoundException {
		Optional<Room> room = roomRepository.findByRoomNumber(roomNumber);
		room.orElseThrow(() -> new ResourceNotFoundException("Room", String.format("Room [%s]", roomNumber)));
		return room.map(RoomDO::new).get();
	}

	@Transactional
	public RoomDO addRoom(String roomNumber, String description) {
		Optional<Room> roomOpt = roomRepository.findByRoomNumber(roomNumber);
		if (roomOpt.isPresent()) {
			throw new ResourceAlreadyExistsException(roomNumber);
		}
		Room room = Room.builder().roomNumber(roomNumber).description(description).build();
		room = roomRepository.save(room);
		return new RoomDO(room);
	}

	@Transactional
	public RoomDO updateRoomDescription(String roomNumber, String description) throws ResourceNotFoundException {
		Optional<Room> room = roomRepository.findByRoomNumber(roomNumber);
		room.orElseThrow(() -> new ResourceNotFoundException("Room", String.format("Room [%s]", roomNumber)));
		room.get().setDescription(description);
		roomRepository.save(room.get());
		return room.map(RoomDO::new).get();
	}
}
