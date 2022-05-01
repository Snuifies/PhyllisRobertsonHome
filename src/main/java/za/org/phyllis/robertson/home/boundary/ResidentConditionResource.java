package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.service.ResidentConditionService;
import za.org.phyllis.robertson.home.service.ResidentService;

@RestController
@RequestMapping("/residents/conditions")
public class ResidentConditionResource {

    @Autowired
    ResidentConditionService conditionService;

    @GetMapping("/{roomNumber}")
    public ResidentConditionResponse findResidentConditions(@PathVariable("roomNumber") String roomNumber) {
        try {
            return ResidentConditionResponse.builder().conditions(conditionService.findResidentConditions(roomNumber)).build();
        } catch (Exception e) {
            return ResidentConditionResponse.builder().message(e.getMessage()).build();
        }
    }

    @PatchMapping("/{roomNumber}/{newCondition}")
    public ResidentConditionResponse addResidentCondition(@PathVariable("roomNumber") String roomNumber,
                                                 @PathVariable("newCondition") String newCondition) {
        try {
            return ResidentConditionResponse.builder().condition(conditionService.addResidentCondition(roomNumber, newCondition)).build();
        } catch (Exception e) {
            return ResidentConditionResponse.builder().message(e.getMessage()).build();
        }
    }

}
