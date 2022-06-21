package  za.co.phyllis.robertson.home.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import  za.co.phyllis.robertson.home.entity.AppUser;
import  za.co.phyllis.robertson.home.repository.AppRoleRepository;
import  za.co.phyllis.robertson.home.repository.AppUserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepository userRepository;

	@Autowired
	private AppRoleRepository appRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> appUser = userRepository.findByUsername(username);
		appUser.orElseThrow(() -> new UsernameNotFoundException("User " + username + " was not found in the database"));
		List<String> userRoles = appRoleRepository.findByUserId(appUser.get().getUserId());
		System.out.println(appUser.get().toString().concat(userRoles.toString()));

		UserDetails user = User.withUsername(appUser.get().getUsername())
			.password(appUser.get().getPassword())
			.authorities(userRoles.stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList())).build();
		return user;
	}

	public static String toString(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("UserName:").append(user.getUsername());
		Collection<GrantedAuthority> authorities = user.getAuthorities();
		if (authorities != null && !authorities.isEmpty()) {
			sb.append(" (");
			boolean first = true;
			for (GrantedAuthority a : authorities) {
				if (first) {
					sb.append(a.getAuthority());
					first = false;
				} else {
					sb.append(", ").append(a.getAuthority());
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}

}
