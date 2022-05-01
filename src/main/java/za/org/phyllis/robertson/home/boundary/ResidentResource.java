package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.BathType;
import za.org.phyllis.robertson.home.model.DietType;
import za.org.phyllis.robertson.home.service.ResidentService;

import java.time.LocalTime;

@RestController
@RequestMapping("/residents")
public class ResidentResource {

    @Autowired
    ResidentService residentService;

    @GetMapping
    public ResidentResponse getAllResidents() {
        return ResidentResponse.builder().residents(residentService.findAllResidents()).build();
    }

    @GetMapping("/id/{idNumber}")
    public ResidentResponse findResidentByIdNumber(@PathVariable("idNumber") String idNumber) {
        try {
            return ResidentResponse.builder().resident(residentService.findResidentByIdNumber(idNumber)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentResponse.builder().message(e.getMessage()).build();
        }
    }

    @GetMapping("/nickname/{nickName}")
    public ResidentResponse findResidentByNickName(@PathVariable("nickName") String nickName) {
        try {
            return ResidentResponse.builder().resident(residentService.findResidentByNickName(nickName)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentResponse.builder().message(e.getMessage()).build();
        }
    }

    @PatchMapping("/nickname/{idNumber}/{newNickName}")
    public ResidentResponse updateResidentByNickName(@PathVariable("idNumber") String idNumber,
                                                     @PathVariable("newNickName") String newNickName) {
        try {
            return ResidentResponse.builder().resident(residentService.updateResidentByNickName(idNumber, newNickName)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentResponse.builder().message(e.getMessage()).build();
        }
    }

    @GetMapping("/dailycare/{idNumber}")
    public ResidentDailyCareResponse findDailyCareByResidentIdNumber(@PathVariable("idNumber") String idNumber) {
        try {
            return ResidentDailyCareResponse.builder().dailyCare(residentService.findDailyCareByResidentIdNumber(idNumber)).build();
        } catch (Exception e) {
            return ResidentDailyCareResponse.builder().message(e.getMessage()).build();
        }
    }

    @PatchMapping("/dailycare/{idNumber}/{bathType}")
    public ResidentDailyCareResponse updateResidentDailyCareBathType(@PathVariable("idNumber") String idNumber, @PathVariable("bathType") BathType bathType) {
        try {
            return ResidentDailyCareResponse.builder().dailyCare(residentService.updateResidentDailyCareBathType(idNumber, bathType)).build();
        } catch (Exception e) {
            return ResidentDailyCareResponse.builder().message(e.getMessage()).build();
        }
    }

    @GetMapping("/meals/{idNumber}")
    public ResidentMealResponse findResidentMealByResidentIdNumber(@PathVariable("idNumber") String idNumber) {
        try {
            return ResidentMealResponse.builder().residentMeal(residentService.findResidentMealByResidentIdNumber(idNumber)).build();
        } catch (Exception e) {
            return ResidentMealResponse.builder().message(e.getMessage()).build();
        }
    }


    @PostMapping("/meals/{idNumber}/{dietType}")
    public ResidentMealResponse updateResidentMealDietType(@PathVariable("idNumber") String idNumber, @PathVariable("dietType") DietType dietType) {
        try {
            return ResidentMealResponse.builder().residentMeal(residentService.updateResidentMealDietType(idNumber, dietType)).build();
        } catch (Exception e) {
            return ResidentMealResponse.builder().message(e.getMessage()).build();
        }
    }

    @GetMapping("/conditions/{idNumber}")
    public ResidentConditionResponse findResidentConditions(@PathVariable("idNumber") String idNumber) {
        try {
            return ResidentConditionResponse.builder().conditions(residentService.findResidentConditionsByResidentIdNumber(idNumber)).build();
        } catch (Exception e) {
            return ResidentConditionResponse.builder().message(e.getMessage()).build();
        }
    }

    @PatchMapping("/conditions/{idNumber}/{newCondition}")
    public ResidentConditionResponse addResidentCondition(@PathVariable("idNumber") String idNumber,
                                                 @PathVariable("newCondition") String newCondition) {
        try {
            return ResidentConditionResponse.builder().conditions(residentService.addResidentCondition(idNumber, newCondition)).build();
        } catch (Exception e) {
            return ResidentConditionResponse.builder().message(e.getMessage()).build();
        }
    }
    @DeleteMapping("/conditions/{idNumber}/{condition}")
    public ResidentConditionResponse deleteResidentCondition(@PathVariable("idNumber") String idNumber,
                                                          @PathVariable("condition") String condition) {
        try {
            return ResidentConditionResponse.builder().conditions(residentService.deleteResidentCondition(idNumber, condition)).build();
        } catch (Exception e) {
            return ResidentConditionResponse.builder().message(e.getMessage()).build();
        }
    }



}
