package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.service.ResidentConditionService;
import za.org.phyllis.robertson.home.service.ResidentService;

@RestController
@RequestMapping("/residents/conditions")
public class ResidentConditionResource {

    @Autowired
    ResidentConditionService conditionService;

    @PatchMapping("/{idNumber}/{newCondition}")
    public ResidentResponse addResidentCondition(@PathVariable("idNumber") String idNumber,
                                                 @PathVariable("newCondition") String newCondition) {
        try {
            return ResidentResponse.builder().resident(conditionService.addResidentCondition(idNumber, newCondition)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentResponse.builder().message(e.getMessage()).build();
        }
    }

}
