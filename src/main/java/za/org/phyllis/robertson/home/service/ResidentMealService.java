package za.org.phyllis.robertson.home.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;
import za.org.phyllis.robertson.home.entity.ResidentMeal;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.DietType;
import za.org.phyllis.robertson.home.model.ResidentDailyCareDO;
import za.org.phyllis.robertson.home.model.ResidentMealDO;
import za.org.phyllis.robertson.home.repository.ResidentDailyCareRepository;
import za.org.phyllis.robertson.home.repository.ResidentMealRepository;

import java.util.Optional;

@Log4j2
@Service
public class ResidentMealService {

    ResidentMealRepository repository;

    @Autowired
    public ResidentMealService(ResidentMealRepository repository) {
        this.repository = repository;
    }

    public ResidentMealDO findResidentMealByRoomNumber(String roomNumber) throws ResourceNotFoundException {
        Optional<ResidentMeal> residentMeal = repository.findByRoomNumber(roomNumber);
        residentMeal.orElseThrow(() -> new ResourceNotFoundException(String.format("Resident Meal Record Not found for Room :%s", roomNumber)));
        return residentMeal.map(ResidentMealDO::new).get();
    }

    public ResidentMealDO updateResidentMealDietType(String roomNumber, DietType dietType) throws ResourceNotFoundException {
        Optional<ResidentMeal> residentMeal = repository.findByRoomNumber(roomNumber);
        residentMeal.orElseThrow(() -> new ResourceNotFoundException(String.format("Resident Meal Record Not found for Room :%s", roomNumber)));
        residentMeal.get().setDietType(dietType);
        repository.save(residentMeal.get());
        return residentMeal.map(ResidentMealDO::new).get();
    }
}
