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
import za.org.phyllis.robertson.home.entity.resident.Condition;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.repository.resident.ConditionRepository;

@RestController
@RequestMapping("/v1/api")
public class ConditionsResource {

    @Resource
    ConditionRepository repository;

    @GetMapping("/conditions")
    public ResponseEntity<List<Condition>> getAllConditions() {
        List<Condition> conditions = repository.findAll();
        return new ResponseEntity<>(conditions, HttpStatus.OK);
    }

    @PostMapping("/conditions/")
    public ResponseEntity<Condition> createCondition(@RequestBody Condition conditions) {
        Condition result = repository.save(Condition.builder().build());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/conditions/{id}")
    public ResponseEntity<Condition> getCondition(@PathVariable("id") long id) {
        Condition conditions = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conditions not Found"));
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
