package za.org.phyllis.robertson.home.resource;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.NotNull;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.service.UserService;

@RestController
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping("/roles")
    public UserResponse getAllRoles() {
        return UserResponse.builder().roles(userService.findAllRoles()).build();
    }

    @GetMapping("/users")
    public UserResponse getAllUsers() {
        return UserResponse.builder().users(userService.findAll()).build();
    }

    @GetMapping("/users/{username}")
    public UserResponse getUser(@PathVariable("username") @NotNull String username) {
        try {
            return UserResponse.builder().user(userService.findByUsername(username)).build();
        } catch (ResourceNotFoundException ex) {
            return UserResponse.builder().message(ex.getMessage()).build();
        }
    }

    @PostMapping("/users/email/{username}/{email}")
    public UserResponse updateUserEmailAddress(@PathVariable("username") @NotNull String username, @PathVariable("email") @NotNull String newEmail) {
        try {
            return UserResponse.builder().user(userService.updateUserEmailAddress(username, newEmail)).build();
        } catch (ResourceNotFoundException ex) {
            return UserResponse.builder().message(ex.getMessage()).build();
        }
    }

    @DeleteMapping("/users/role/{username}/{role}")
    public UserResponse deleteUserRole(@PathVariable("username") @NotNull String username, @PathVariable("role") @NotNull String role) {
        try {
            return UserResponse.builder().user(userService.deleteUserRole(username, role)).build();
        } catch (ResourceNotFoundException ex) {
            return UserResponse.builder().message(ex.getMessage()).build();
        }
    }

    @PostMapping("/users/role/{username}/{role}")
    public UserResponse addUserRole(@PathVariable("username") @NotNull String username, @PathVariable("role") @NotNull String role) {
        try {
            return UserResponse.builder().user(userService.addUserRole(username, role)).build();
        } catch (ResourceNotFoundException ex) {
            return UserResponse.builder().message(ex.getMessage()).build();
        }
    }
}
