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
import za.org.phyllis.robertson.home.model.ResidentDO;
import za.org.phyllis.robertson.home.repository.ResidentConditionRepository;
import za.org.phyllis.robertson.home.repository.ResidentRepository;

import java.util.List;
import java.util.Optional;
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

//    public ResidentDO addResidentCondition(String idNumber, String newCondition) throws ResourceNotFoundException {
//        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
//        resident.orElseThrow(() -> new ResourceNotFoundException(String.format("ID Number :%s", idNumber)));
//        Optional<Boolean> conditionAlreadyLogged = resident.get().getConditions().stream().map(condition -> condition.getCondition().equalsIgnoreCase(newCondition)).findFirst();
//        if (conditionAlreadyLogged.isPresent() && conditionAlreadyLogged.get().booleanValue() == true) {
//            throw new ResourceAlreadyExistsException(String.format("ID Number [%s]: Condition [%s]", idNumber, newCondition));
//        }
//        ResidentCondition condition = ResidentCondition.builder().resident(resident.get()).roomNumber(resident.get().getRoomNumber()).condition(newCondition).build();
//        resident.get().getConditions().add(condition);
//        residentRepository.save(resident.get());
//        conditionRepository.save(condition);
//        return resident.map(ResidentDO::new).get();
//    }

}
