package za.org.phyllis.robertson.home.boundary;

import org.jboss.jandex.AnnotationTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.BathType;
import za.org.phyllis.robertson.home.service.ResidentDailyCareService;
import za.org.phyllis.robertson.home.service.ResidentService;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RequestMapping("/residents/dailycare")
public class ResidentDailyCareResource {

    @Autowired
    ResidentDailyCareService service;

      @GetMapping("/{roomNumber}")
    public ResidentDailyCareResponse findDailyCareByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        try {
            return ResidentDailyCareResponse.builder().dailyCare(service.findDailyCareByRoomNumber(roomNumber)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentDailyCareResponse.builder().message(e.getMessage()).build();
        }
    }

    @PostMapping("/{roomNumber}/{bathType}")
    public ResidentDailyCareResponse updateDailyCareBathType(@PathVariable("roomNumber") String roomNumber, @PathVariable("bathType") BathType bathType) {
        try {
            return ResidentDailyCareResponse.builder().dailyCare(service.updateDailyCareBathType(roomNumber, bathType)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentDailyCareResponse.builder().message(e.getMessage()).build();
        }
    }

    @PatchMapping("/{roomNumber}/{medicationTime}")
    public ResidentDailyCareResponse updateDailyCareMedicationAcuteTime(@PathVariable("roomNumber") String roomNumber, @PathVariable("medicationTime") @DateTimeFormat(pattern = "HH:mm") LocalTime medicationTime) {
        try {
            return ResidentDailyCareResponse.builder().dailyCare(service.updateDailyCareMedicationAcuteTime(roomNumber, medicationTime)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentDailyCareResponse.builder().message(e.getMessage()).build();
        }
    }
}
