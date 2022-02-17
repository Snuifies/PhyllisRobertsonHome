package za.org.phyllis.robertson.home.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.entity.Conditions;
import za.org.phyllis.robertson.home.entity.Resident;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionsRepositoryTest {

    @Resource
    ConditionRepository conditionRepository;
    @Resource
    ResidentRepository residentRepository;

    @Test
    public void givenCondition_whenSave_thenGetOk() {
	Resident resident = Resident.builder().build();
	residentRepository.save(resident);
	Conditions model = Conditions.builder().condition("Fartiner").resident(resident).build();
	conditionRepository.save(model);
	List<Conditions> entities = conditionRepository.findAll();
	assertNotNull(entities);
	assertEquals("Fartiner", entities.get(0).getCondition());
	assertEquals(1, entities.get(0).getResident().getId());
    }

}
