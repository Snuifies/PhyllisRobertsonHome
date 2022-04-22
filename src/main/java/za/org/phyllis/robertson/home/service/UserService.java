package za.org.phyllis.robertson.home.service;

import java.util.List;
import za.org.phyllis.robertson.home.entity.User;
import za.org.phyllis.robertson.home.model.UserDO;
import za.org.phyllis.robertson.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import za.org.phyllis.robertson.home.model.RoleDO;
import za.org.phyllis.robertson.home.entity.Role;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.repository.RoleRepository;

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
    public UserDO find(String username) throws ResourceNotFoundException {
	Optional<User> user = userRepository.findByUsername(username);
	user.orElseThrow(() -> new ResourceNotFoundException(username));
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
}
