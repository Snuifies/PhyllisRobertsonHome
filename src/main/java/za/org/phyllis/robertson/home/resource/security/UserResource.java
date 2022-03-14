package za.org.phyllis.robertson.home.resource.security;

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
import za.org.phyllis.robertson.home.api.model.UserDO;
import za.org.phyllis.robertson.home.service.security.UserServiceImpl;

/**
 *
 * @author snuif
 */
@RestController
@RequestMapping("/v1/api/users")
public class UserResource {

    @Resource
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserDO>> getAllUsers() {
	return new ResponseEntity<List<UserDO>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<UserDO> getUser(@PathVariable("username") String username) {
	return new ResponseEntity<UserDO>(userService.getUserByName(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDO> createUser(@RequestBody UserDO userDO) {
	UserDO result = userService.createUser(userDO);
	return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
	userService.deleteUser(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllUsers() {
	userService.deleteAllUsers();
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
