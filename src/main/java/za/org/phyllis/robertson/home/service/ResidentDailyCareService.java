package za.org.phyllis.robertson.home.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.BathType;
import za.org.phyllis.robertson.home.model.ResidentDailyCareDO;
import za.org.phyllis.robertson.home.repository.ResidentDailyCareRepository;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Log4j2
@Service
public class ResidentDailyCareService {

    ResidentDailyCareRepository repository;

    @Autowired
    public ResidentDailyCareService(ResidentDailyCareRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public ResidentDailyCareDO findDailyCareByRoomNumber(String roomNumber) throws ResourceNotFoundException {
//        Optional<ResidentDailyCare> dailyCare = repository.findByRoomNumber(roomNumber);
//        dailyCare.orElseThrow(() -> new ResourceNotFoundException("ResidentDailyCare", String.format("Daily Care Record Not found for Room [%s]", roomNumber)));
//        return dailyCare.map(ResidentDailyCareDO::new).get();
        return null;
    }

    @Transactional
    public ResidentDailyCareDO updateDailyCareBathType(String roomNumber, BathType bathType) throws ResourceNotFoundException {
//        Optional<ResidentDailyCare> dailyCare = repository.findByRoomNumber(roomNumber);
//        dailyCare.orElseThrow(() -> new ResourceNotFoundException("ResidentDailyCare", String.format("Daily Care Record Not found for Room [%s]", roomNumber)));
//        dailyCare.get().setBath(bathType);
//        repository.save(dailyCare.get());
//        return dailyCare.map(ResidentDailyCareDO::new).get();
        return null;
    }

    @Transactional
    public ResidentDailyCareDO updateDailyCareMedicationAcuteTime(String roomNumber, LocalTime medicationTime) throws ResourceNotFoundException {
//        Optional<ResidentDailyCare> dailyCare = repository.findByRoomNumber(roomNumber);
//        dailyCare.orElseThrow(() -> new ResourceNotFoundException("ResidentDailyCare", String.format("Daily Care Record Not found for Room [%s]", roomNumber)));
//        dailyCare.get().setMedicationAcuteTime(medicationTime.getHour() + ":" + medicationTime.getMinute());
//        repository.save(dailyCare.get());
//        return dailyCare.map(ResidentDailyCareDO::new).get();
        return null;
    }
//
//    public ResidentDailyCareDO findDailyCareByResidentIdNumber(String idNumber) throws ResourceNotFoundException {
//        Optional<ResidentDailyCare> dailyCare = repository.findByResidentIdNumber(idNumber);
//        dailyCare.orElseThrow(() -> new ResourceNotFoundException("ResidentDailyCare", String.format("Id Number [%s]", idNumber)));
//        return dailyCare.map(ResidentDailyCareDO::new).get();
//    }
}
