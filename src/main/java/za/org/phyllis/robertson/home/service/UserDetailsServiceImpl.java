package za.org.phyllis.robertson.home.service;

import za.org.phyllis.robertson.home.entity.User;
import za.org.phyllis.robertson.home.model.UserDetailsImpl;
import za.org.phyllis.robertson.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl{// implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//        user.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//        return user.map(UserDetailsImpl::new).get();
//    }
}
