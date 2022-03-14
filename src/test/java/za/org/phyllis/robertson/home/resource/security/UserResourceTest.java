package za.org.phyllis.robertson.home.resource.security;

import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import za.org.phyllis.robertson.home.api.model.UserDO;
import za.org.phyllis.robertson.home.entity.security.Role;
import za.org.phyllis.robertson.home.repository.security.RoleRepository;

/**
 *
 * @author snuif
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResourceTest {

    @Resource
    UserResource userResource;
    @Resource
    RoleRepository roleRepository;

    @Test
    public void shouldGetAllUsers() {
	ResponseEntity<List<UserDO>> users = userResource.getAllUsers();
	assertNotNull(users.getBody());
    }

    @Test
    public void shouldGetUser() {
	ResponseEntity<UserDO> user = userResource.getUser("admin");
	assertNotNull(user.getBody());
	assertEquals("admin", user.getBody().getUsername());
    }

    @Test
    public void shouldCreateUser() {
	String email = "username@mail.org";
	String username = "username";
	String password = "password";
	Role role = roleRepository.findByRole("staff").get();
	UserDO userDO = UserDO.builder()
		.email(email)
		.username(username)
		.password(password)
		.build();
	userDO.addRole(role.getRole());
	ResponseEntity<UserDO> user = userResource.createUser(userDO);
	assertNotNull(user.getBody());
    }

    @Test
    public void shouldDeleteUser() {
	String email = "username@mail.org";
	String username = "username";
	String password = "password";
	Role role = roleRepository.findByRole("staff").get();
	UserDO userDO = UserDO.builder()
		.email(email)
		.username(username)
		.password(password)
		.build();
	userDO.addRole(role.getRole());
	ResponseEntity<UserDO> user = userResource.createUser(userDO);
	assertNotNull(user.getBody());
	userResource.deleteUser(user.getBody().getId());
	user = userResource.getUser(username);
	assertNull(user.getBody());
    }

//    @Test
//    public void shouldDeleteAllUsers() {
//	userResource.deleteAllUsers();
//	ResponseEntity<List<UserDO>> users = userResource.getAllUsers();
//	assertTrue(users.getBody().isEmpty());
//    }

}
