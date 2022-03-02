package za.org.phyllis.robertson.home.resource.resident;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.org.phyllis.robertson.home.entity.resident.Resident;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.repository.resident.ResidentRepository;

@RestController
@RequestMapping("/v1/api")
public class ResidentResource {

    @Resource
    ResidentRepository repository;

    @GetMapping("/residents")
    public ResponseEntity<List<Resident>> getAllResidents() {
        List<Resident> residents = repository.findAll();
        return new ResponseEntity<>(residents, HttpStatus.OK);
    }

    @PostMapping("/residents/")
    public ResponseEntity<Resident> createResident(@RequestBody Resident resident) {
        Resident result = repository.save(Resident.builder().build());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/residents/{id}")
    public ResponseEntity<Resident> getResident(@PathVariable("id") long id) {
        Resident resident = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not Found"));
        return new ResponseEntity<>(resident, HttpStatus.OK);
    }

    @DeleteMapping("/residents/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/residents")
    public ResponseEntity<HttpStatus> deleteAllResidents() {
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
