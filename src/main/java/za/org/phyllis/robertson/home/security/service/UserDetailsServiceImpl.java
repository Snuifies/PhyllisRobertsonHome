package za.org.phyllis.robertson.home.security.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.org.phyllis.robertson.home.security.entity.AppUser;
import za.org.phyllis.robertson.home.security.repository.AppRoleRepository;
import za.org.phyllis.robertson.home.security.repository.AppUserRepository;

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

        UserDetails user = User.withUsername(appUser.get().getUserName())
            .password(appUser.get().getPassword())
            .authorities(userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList())).build();
        return user;
    }
}
