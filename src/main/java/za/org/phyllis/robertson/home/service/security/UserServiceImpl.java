package za.org.phyllis.robertson.home.service.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.api.model.UserDO;
import za.org.phyllis.robertson.home.entity.security.User;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.repository.security.UserRepository;

@Service
public class UserServiceImpl {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    public void deleteAllUsers() {
	userRepository.deleteAll();
    }

    @Transactional
    public void deleteUser(long id) {
	userRepository.deleteById(id);
    }

    @Transactional
    public UserDO createUser(UserDO userDO) {
	if (userRepository.findByUsername(userDO.getUsername()).isPresent()) {
	    throw new ResourceNotFoundException(userDO.getUsername());
	};
	User user = new User(userDO.getUsername(), userDO.getPassword(), userDO.getEmail());
	user = userRepository.save(user);
	return new UserDO(user);
    }

    @Transactional
    public UserDO getUser(Long id) {
	return userRepository.findById(id)
		.map(UserDO::new)
		.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Transactional
    public List<UserDO> getAllUsers() {
	List<UserDO> userDOs = new ArrayList<>();
	userRepository.findAll().forEach((user) -> {
	    userDOs.add(new UserDO(user));
	});
	return userDOs;
    }

    @Transactional
    public UserDO getUserByName(String username) {
	return userRepository.findByUsername(username)
		.map(UserDO::new)
		.orElseThrow(() -> new ResourceNotFoundException(username));
    }
}
