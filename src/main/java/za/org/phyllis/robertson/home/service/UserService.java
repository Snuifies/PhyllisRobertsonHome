package za.org.phyllis.robertson.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.entity.Role;
import za.org.phyllis.robertson.home.entity.User;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.RoleDO;
import za.org.phyllis.robertson.home.model.UserDO;
import za.org.phyllis.robertson.home.repository.RoleRepository;
import za.org.phyllis.robertson.home.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public UserDO findByUsername(String username) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new ResourceNotFoundException(String.format("User :%s", username)));
        return user.map(UserDO::new).get();
    }

    @Transactional
    public List<UserDO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDO::new).collect(Collectors.toList());
    }

    @Transactional
    public List<RoleDO> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(RoleDO::new).collect(Collectors.toList());
    }

    @Transactional
    public UserDO updateUserEmailAddress(String username, String newEmail) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new ResourceNotFoundException(String.format("User :%s", username)));
        user.get().setEmail(newEmail);
        userRepository.save(user.get());
        return user.map(UserDO::new).get();
    }

    @Transactional
    public UserDO deleteUserRole(String username, String role) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new ResourceNotFoundException(String.format("User :%s", username)));
        Role entity = user.get().getRoles().stream().filter((r) -> r.getRole().equalsIgnoreCase(role)).findFirst().get();
        user.get().getRoles().remove(entity);
        userRepository.save(user.get());
        user = userRepository.findByUsername(username);
        return user.map(UserDO::new).get();
    }

    @Transactional
    public UserDO addUserRole(String username, String newRole) throws ResourceNotFoundException {
        Optional<User> userEntity = userRepository.findByUsername(username);
        userEntity.orElseThrow(() -> new ResourceNotFoundException(String.format("User :%s", username)));
        Optional<Role> roleEntity = roleRepository.findByRole(newRole);
        roleEntity.orElseThrow(() -> new ResourceNotFoundException(String.format("Role :%s", newRole)));
        userEntity.get().getRoles().add(roleEntity.get());
        userRepository.save(userEntity.get());
        userEntity = userRepository.findByUsername(username);
        return userEntity.map(UserDO::new).get();

    }

    @Transactional
    public UserDO changeUserRole(String username, String newRole) throws ResourceNotFoundException {
        Optional<User> userEntity = userRepository.findByUsername(username);
        userEntity.orElseThrow(() -> new ResourceNotFoundException(String.format("User :%s", username)));
        Optional<Role> roleEntity = roleRepository.findByRole(newRole);
        roleEntity.orElseThrow(() -> new ResourceNotFoundException(String.format("Role :%s", newRole)));
        userEntity.get().getRoles().clear();
        userRepository.save(userEntity.get());
        userEntity.get().getRoles().add(roleEntity.get());
        userRepository.save(userEntity.get());
        userEntity = userRepository.findByUsername(username);
        return userEntity.map(UserDO::new).get();
    }

}
