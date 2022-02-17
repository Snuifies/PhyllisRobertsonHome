package za.org.phyllis.robertson.home.repository;
import java.util.List;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.entity.Resident;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ResidentRepositoryTest {

    @Resource
    ResidentRepository repository;

    @Test
    public void givenResident_whenSave_thenGetOk() {
        Resident model = new Resident();
        repository.save(model);
        List<Resident> entities = repository.findAll();
        assertNotNull(entities);
        assertNotNull(entities.get(0).getId());
    }

}
