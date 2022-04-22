package za.org.phyllis.robertson.home.resource;

import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.org.phyllis.robertson.home.service.UserService;

@RestController
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public UserResponse getAllUsers() {
	return UserResponse.builder().users(userService.findAll()).build();
    }

    @GetMapping("/roles")
    public UserResponse getAllRoles() {
	return UserResponse.builder().roles(userService.findAllRoles()).build();
    }
}
