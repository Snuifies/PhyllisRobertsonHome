package za.org.phyllis.robertson.home.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.security.entity.AppUser;
import za.org.phyllis.robertson.home.security.repository.AppRoleRepository;
import za.org.phyllis.robertson.home.security.repository.AppUserRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class AppUserService {

    AppUserRepository userRepository;

    AppRoleRepository roleRepository;

    @Transactional
    public List<UserDetails> findAll() {
        List<UserDetails> userDetails = new ArrayList<>();
        List<AppUser> appUsers = userRepository.findAll();
        appUsers.stream().forEach((appUser) -> {
            List<String> userRoles = roleRepository.findByUserId(appUser.getUserId());
            UserDetails user = User.withUsername(appUser.getUserName())
                .password(appUser.getPassword())
                .authorities(userRoles.stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toList())).build();
            userDetails.add(user);
        });
        return userDetails;
    }

}
