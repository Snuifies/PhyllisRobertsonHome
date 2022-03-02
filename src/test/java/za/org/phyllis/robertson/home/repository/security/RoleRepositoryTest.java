package za.org.phyllis.robertson.home.repository.security;

import za.org.phyllis.robertson.home.model.security.UserRole;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	assertNotNull(roleRepository.findByName(UserRole.STAFF).get());
	assertNotNull(roleRepository.findByName(UserRole.MANAGER).get());
	assertNotNull(roleRepository.findByName(UserRole.ADMINISTRATOR).get());
    }
}
