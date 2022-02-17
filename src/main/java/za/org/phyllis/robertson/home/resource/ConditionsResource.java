package za.org.phyllis.robertson.home.resource;

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
import za.org.phyllis.robertson.home.entity.Conditions;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.repository.ConditionRepository;

@RestController
@RequestMapping("/v1/api")
public class ConditionsResource {

    @Resource
    ConditionRepository repository;

    @GetMapping("/conditions")
    public ResponseEntity<List<Conditions>> getAllConditions() {
        List<Conditions> conditions = repository.findAll();
        return new ResponseEntity<>(conditions, HttpStatus.OK);
    }

    @PostMapping("/conditions/")
    public ResponseEntity<Conditions> createCondition(@RequestBody Conditions conditions) {
        Conditions result = repository.save(Conditions.builder().build());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/conditions/{id}")
    public ResponseEntity<Conditions> getCondition(@PathVariable("id") long id) {
        Conditions conditions = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conditions not Found"));
        return new ResponseEntity<>(conditions, HttpStatus.OK);
    }

    @DeleteMapping("/conditions/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/conditions")
    public ResponseEntity<HttpStatus> deleteAllResidents() {
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
