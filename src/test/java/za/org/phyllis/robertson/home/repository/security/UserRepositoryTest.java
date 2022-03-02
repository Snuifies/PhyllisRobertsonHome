package za.org.phyllis.robertson.home.repository.security;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import za.org.phyllis.robertson.home.entity.security.Role;
import za.org.phyllis.robertson.home.entity.security.User;
import za.org.phyllis.robertson.home.model.security.UserRole;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class UserRepositoryTest {

    @Resource
    UserRepository userRepository;

    @Resource
    RoleRepository roleRepository;

    @Test
    void testUserRepository() {
	Role staff = roleRepository.findByName(UserRole.STAFF).get();
	Role manager = roleRepository.findByName(UserRole.STAFF).get();
	User user = new User(0L,
		"Peter",
		"Pan",
		"Pan@gmail.com",
		Stream.of(staff, manager)
			.collect(Collectors.toSet()));
	userRepository.saveAndFlush(user);
	assertNotNull(userRepository.findById(user.getId()));
	assertNotNull(userRepository.findByUsername(user.getUsername()));
	assertNotNull(userRepository.findByUsernameAndEmail(user.getUsername(), user.getEmail()));
	assertTrue(userRepository.existsByUsername(user.getUsername()));
	assertTrue(userRepository.existsByEmail(user.getEmail()));
    }
}
