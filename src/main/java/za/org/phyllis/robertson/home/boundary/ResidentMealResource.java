package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.BathType;
import za.org.phyllis.robertson.home.model.DietType;
import za.org.phyllis.robertson.home.service.ResidentDailyCareService;
import za.org.phyllis.robertson.home.service.ResidentMealService;

import java.time.LocalTime;

@RestController
@RequestMapping("/residents/meals")
public class ResidentMealResource {

    @Autowired
    ResidentMealService service;

      @GetMapping("/{roomNumber}")
    public ResidentMealResponse findResidentMealByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        try {
            return ResidentMealResponse.builder().residentMeal(service.findResidentMealByRoomNumber(roomNumber)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentMealResponse.builder().message(e.getMessage()).build();
        }
    }

    @PostMapping("/{roomNumber}/{dietType}")
    public ResidentMealResponse updateResidentMealDietType(@PathVariable("roomNumber") String roomNumber, @PathVariable("dietType") DietType dietType) {
        try {
            return ResidentMealResponse.builder().residentMeal(service.updateResidentMealDietType(roomNumber, dietType)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentMealResponse.builder().message(e.getMessage()).build();
        }
    }

}
