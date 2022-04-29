package za.org.phyllis.robertson.home.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.Room;
import za.org.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.ResidentDO;
import za.org.phyllis.robertson.home.model.RoomDO;
import za.org.phyllis.robertson.home.repository.ResidentRepository;
import za.org.phyllis.robertson.home.repository.RoomRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ResidentService {

    ResidentRepository residentRepository;

    @Autowired
    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    public List<ResidentDO> findAllResidents() {
        return residentRepository.findAll().stream().map(ResidentDO::new).collect(Collectors.toList());
    }


    @Transactional
    public ResidentDO findResidentByIdNumber(String idNumber) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException(String.format("ID Number :%s", idNumber)));
        return resident.map(ResidentDO::new).get();
    }

    @Transactional
    public ResidentDO findResidentByNickName(String nickName) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByNickName(nickName);
        resident.orElseThrow(() -> new ResourceNotFoundException(String.format("NickName :%s", nickName)));
        return resident.map(ResidentDO::new).get();
    }

    @Transactional
    public ResidentDO changeResidentNickName(String idNumber, String newNickName) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException(String.format("ID Number :%s", idNumber)));
        resident.get().setNickName(newNickName);
        residentRepository.save(resident.get());
        return resident.map(ResidentDO::new).get();
    }
}
