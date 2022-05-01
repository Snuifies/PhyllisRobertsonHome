package za.org.phyllis.robertson.home.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.service.UserService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping("/roles")
    public UserResponse getAllRoles() {
        return UserResponse.builder().roles(userService.findAllRoles()).build();
    }

    @GetMapping
    public UserResponse getAllUsers() {
        return UserResponse.builder().users(userService.findAll()).build();
    }

    @GetMapping("/{username}")
    public UserResponse getUser(@PathVariable("username") @NotNull String username) {
        try {
            return UserResponse.builder().user(userService.findByUsername(username)).build();
        } catch (Exception e) {
            return UserResponse.builder().message(e.getMessage()).build();
        }
    }

    @PostMapping("/{username}/{email}")
    public UserResponse updateUserEmailAddress(@PathVariable("username") @NotNull String username, @PathVariable("email") @NotNull String newEmail) {
        try {
            return UserResponse.builder().user(userService.updateUserEmailAddress(username, newEmail)).build();
        } catch (Exception e) {
            return UserResponse.builder().message(e.getMessage()).build();
        }
    }

    @DeleteMapping("/role/{username}/{role}")
    public UserResponse deleteUserRole(@PathVariable("username") @NotNull String username, @PathVariable("role") @NotNull String role) {
        try {
            return UserResponse.builder().user(userService.deleteUserRole(username, role)).build();
        } catch (Exception e) {
            return UserResponse.builder().message(e.getMessage()).build();
        }
    }

    @PostMapping("/role/{username}/{role}")
    public UserResponse addUserRole(@PathVariable("username") @NotNull String username, @PathVariable("role") @NotNull String role) {
        try {
            return UserResponse.builder().user(userService.addUserRole(username, role)).build();
        } catch (Exception e) {
            return UserResponse.builder().message(e.getMessage()).build();
        }
    }
}