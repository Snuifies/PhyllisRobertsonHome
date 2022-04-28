package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.service.ResidentService;

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

    @GetMapping("/room/{roomNumber}")
    public ResidentResponse findResidentByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        try {
            return ResidentResponse.builder().resident(residentService.findResidentByRoomNumber(roomNumber)).build();
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
    public ResidentResponse findResidentByNickName(@PathVariable("idNumber") String idNumber,
                                                   @PathVariable("newNickName") String newNickName) {
        try {
            return ResidentResponse.builder().resident(residentService.changeResidentNickName(idNumber, newNickName)).build();
        } catch (ResourceNotFoundException e) {
            return ResidentResponse.builder().message(e.getMessage()).build();
        }
    }
}
