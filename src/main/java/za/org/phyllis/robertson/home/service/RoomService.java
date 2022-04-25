package za.org.phyllis.robertson.home.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.org.phyllis.robertson.home.entity.Room;
import za.org.phyllis.robertson.home.model.RoleDO;
import za.org.phyllis.robertson.home.repository.RoleRepository;
import za.org.phyllis.robertson.home.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class RoomService {

    RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }
}
