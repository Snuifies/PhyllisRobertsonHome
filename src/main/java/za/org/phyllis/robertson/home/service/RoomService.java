package za.org.phyllis.robertson.home.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.org.phyllis.robertson.home.entity.Room;
import za.org.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.RoomDO;
import za.org.phyllis.robertson.home.repository.RoomRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class RoomService {

    RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomDO> findAllRooms() {
        return roomRepository.findAll().stream().map(RoomDO::new).collect(Collectors.toList());
    }

    public RoomDO findByRoomNumber(String roomNumber) throws ResourceNotFoundException {
        Optional<Room> room = roomRepository.findByRoomNumber(roomNumber);
        room.orElseThrow(() -> new ResourceNotFoundException(String.format("Room :%s", roomNumber)));
        return room.map(RoomDO::new).get();
    }

    public RoomDO addRoom(String roomNumber, String description) {
        Optional<Room> roomOpt = roomRepository.findByRoomNumber(roomNumber);
        if (roomOpt.isPresent()) {
            throw new ResourceAlreadyExistsException(roomNumber);
        }
        Room room = Room.builder().roomNumber(roomNumber).description(description).build();
        room = roomRepository.save(room);
        return new RoomDO(room);
    }

    public RoomDO updateRoomDescription(String roomNumber, String description) throws ResourceNotFoundException {
        Optional<Room> room = roomRepository.findByRoomNumber(roomNumber);
        room.orElseThrow(() -> new ResourceNotFoundException(String.format("Room :%s", roomNumber)));
        room.get().setDescription(description);
        roomRepository.save(room.get());
        return  room.map(RoomDO::new).get();
     }
}
