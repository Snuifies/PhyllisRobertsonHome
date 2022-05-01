package za.org.phyllis.robertson.home.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.ResidentCondition;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;
import za.org.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.BathType;
import za.org.phyllis.robertson.home.model.ResidentDO;
import za.org.phyllis.robertson.home.model.ResidentDailyCareDO;
import za.org.phyllis.robertson.home.repository.ResidentDailyCareRepository;
import za.org.phyllis.robertson.home.repository.ResidentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ResidentService {

    ResidentRepository residentRepository;
    ResidentDailyCareRepository careRepository;
    @Autowired
    public ResidentService(ResidentRepository residentRepository,
                           ResidentDailyCareRepository careRepository) {
        this.residentRepository = residentRepository;
        this.careRepository = careRepository;
    }

    @Transactional
    public List<ResidentDO> findAllResidents() {
        return residentRepository.findAll().stream().map(ResidentDO::new).collect(Collectors.toList());
    }

    @Transactional
    public ResidentDO findResidentByIdNumber(String idNumber) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        return resident.map(ResidentDO::new).get();
    }

    @Transactional
    public ResidentDO findResidentByNickName(String nickName) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByNickName(nickName);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("NickName [%s]", nickName)));
        return resident.map(ResidentDO::new).get();
    }

    @Transactional
    public ResidentDO updateResidentByNickName(String idNumber, String newNickName) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        resident.get().setNickName(newNickName);
        residentRepository.save(resident.get());
        return resident.map(ResidentDO::new).get();
    }

    public ResidentDailyCareDO findDailyCareByResidentIdNumber(String idNumber) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        ResidentDailyCare dailyCare = resident.get().getResidentDailyCare();
        return new ResidentDailyCareDO(dailyCare);
    }

    @Transactional
    public ResidentDailyCareDO updateResidentDailyCareBathType(String idNumber, BathType bathType) throws ResourceNotFoundException {
        Optional<Resident> resident = residentRepository.findByIdNumber(idNumber);
        resident.orElseThrow(() -> new ResourceNotFoundException("Resident", String.format("ID Number [%s]", idNumber)));
        ResidentDailyCare dailyCare = resident.get().getResidentDailyCare();
        dailyCare.setBath(bathType);
        careRepository.save(dailyCare);
        return new ResidentDailyCareDO(dailyCare);
    }

}
