package spring.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.security.entity.AppRole;
import spring.security.entity.AppUser;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;


    public UserDetailsImpl(AppUser user, List<String> roles) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isEnabled();
        this.authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
