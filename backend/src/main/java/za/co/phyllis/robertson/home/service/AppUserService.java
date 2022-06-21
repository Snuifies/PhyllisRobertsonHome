package  za.co.phyllis.robertson.home.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import  za.co.phyllis.robertson.home.entity.AppUser;
import  za.co.phyllis.robertson.home.entity.PersistentLogin;
import  za.co.phyllis.robertson.home.model.AppUserModel;
import  za.co.phyllis.robertson.home.repository.AppRoleRepository;
import  za.co.phyllis.robertson.home.repository.AppUserRepository;
import  za.co.phyllis.robertson.home.repository.PersistentLoginRepository;

@Service
@Log4j2
public class AppUserService {

	@Autowired
	AppUserRepository userRepository;

	@Autowired
	AppRoleRepository roleRepository;

	@Autowired
	PersistentLoginRepository loginRepository;

	@Transactional
	public List<UserDetails> findAll() {
		List<UserDetails> userDetails = new ArrayList<>();
		List<AppUser> appUsers = userRepository.findAll();
		appUsers.stream().forEach((appUser) -> {
			List<String> userRoles = roleRepository.findByUserId(appUser.getUserId());
			UserDetails user = User.withUsername(appUser.getUsername())
				.password(appUser.getPassword())
				.authorities(userRoles.stream()
					.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toList())).build();
			userDetails.add(user);
		});
		return userDetails;
	}

	public List<AppUserModel> findAllUsers() {
		List<AppUserModel> models = new ArrayList<>();
		List<AppUser> appUsers = userRepository.findAll();
		appUsers.stream().forEach((appUser) -> {
			List<String> userRoles = roleRepository.findByUserId(appUser.getUserId());
			AppUserModel model = AppUserModel.builder().username(appUser.getUsername()).enabled(appUser.isEnabled()).expired(appUser.isExpired()).locked(appUser.isLocked()).roles(userRoles).build();
			Optional<PersistentLogin> persistentLogin = loginRepository.findByUsername(appUser.getUsername());
			persistentLogin.ifPresent((t) -> {
				model.setLastUsed(t.getLastUsed());
			});
			models.add(model);
		});
		return models;
	}

}
