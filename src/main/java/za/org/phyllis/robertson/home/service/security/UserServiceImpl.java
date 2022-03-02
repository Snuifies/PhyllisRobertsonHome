package za.org.phyllis.robertson.home.service.security;

import java.util.ArrayList;
import java.util.List;
import za.org.phyllis.robertson.home.model.security.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserDO saveUser(UserDO userDO) {
	return userRepository.findById(userDO.getId())
		.map(UserDO::new).get();
    }

    @Transactional
    public UserDO getUser(long id) {
	return userRepository.findById(id)
		.map(UserDO::new)
		.orElseThrow(() -> new ResourceNotFoundException("User not Found"));
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
		.orElseThrow(() -> new ResourceNotFoundException("User not Found"));
    }
}
