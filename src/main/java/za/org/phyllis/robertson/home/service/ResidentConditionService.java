package za.org.phyllis.robertson.home.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.boundary.ResidentConditionResource;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.ResidentCondition;
import za.org.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.ResidentConditionDO;
import za.org.phyllis.robertson.home.model.ResidentDO;
import za.org.phyllis.robertson.home.repository.ResidentConditionRepository;
import za.org.phyllis.robertson.home.repository.ResidentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ResidentConditionService {

    ResidentConditionRepository conditionRepository;
    ResidentRepository residentRepository;

    @Autowired
    public ResidentConditionService(ResidentRepository residentRepository, ResidentConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    public ResidentDO addResidentCondition(String roomNumber, String newCondition) throws ResourceNotFoundException {
//        Optional<Resident> resident = residentRepository.findByRoomNumber(roomNumber);
//        List<ResidentCondition> conditions = conditionRepository.findByRoomNumber(roomNumber);
//        if (!conditions.isEmpty()) {
//            Optional<ResidentCondition> existingCondition = conditions.stream().filter(condition -> condition.equals(newCondition)).findFirst();
//            if (existingCondition.isPresent()) {
//                throw new ResourceAlreadyExistsException(String.format("Room Number [%s] Condition [%s]", roomNumber, newCondition));
//            }
//        }
//        ResidentCondition condition = ResidentCondition.builder().resident(resident.get()).condition(newCondition).build();
//        conditionRepository.save(condition);
//        return resident.map(ResidentDO::new).get();
        return null;
    }

    @Transactional
    public List<ResidentConditionDO> findResidentConditions(String roomNumber) throws ResourceNotFoundException {
//        List<ResidentCondition> conditions = conditionRepository.findByRoomNumber(roomNumber);
//        if (Objects.isNull(conditions) || conditions.isEmpty()) {
//            throw new ResourceNotFoundException("ResidentCondition", String.format("Room Number [%s]", roomNumber));
//        }
//        return conditions.stream().map(ResidentConditionDO::new).collect(Collectors.toList());
        return null;
    }
}
