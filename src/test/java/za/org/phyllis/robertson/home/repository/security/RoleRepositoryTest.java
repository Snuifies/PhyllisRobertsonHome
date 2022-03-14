package za.org.phyllis.robertson.home.repository.security;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.api.model.UserRole;

/**
 *
 * @author snuif
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Resource
    RoleRepository roleRepository;

    @Test
    void testUserRepository() {
	assertNotNull(roleRepository.findByRole(UserRole.STAFF.name()).get());
	assertNotNull(roleRepository.findByRole(UserRole.MANAGER.name()).get());
	assertNotNull(roleRepository.findByRole(UserRole.ADMINISTRATOR.name()).get());
    }
}
