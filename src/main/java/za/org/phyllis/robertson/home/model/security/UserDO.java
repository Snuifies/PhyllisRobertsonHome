package za.org.phyllis.robertson.home.model.security;

import java.util.*;
import java.util.stream.Collectors;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import za.org.phyllis.robertson.home.entity.security.User;

@Builder
public class UserDO implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String email;
    private String password;
    private ArrayList<UserRole> userRoles;

    public UserDO(User user) {
	this(user.getId(),
		user.getUsername(),
		user.getEmail(),
		user.getPassword(),
		user.getRoles()
			.stream()
			.map(role -> role.getName())
			.collect(Collectors.toList()));
    }

    public UserDO(Long id, String username, String email, String password,
	    Collection<? extends UserRole> roles) {
	this.id = id;
	this.username = username;
	this.email = email;
	this.password = password;
	if (Objects.nonNull(roles) && !roles.isEmpty()) {
	    this.userRoles = new ArrayList(roles);
	}
    }

    public Collection<UserRole> getRoles() {
	return userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    public Long getId() {
	return id;
    }

    public String getEmail() {
	return email;
    }

    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public String getUsername() {
	return username;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	UserDO user = (UserDO) o;
	return Objects.equals(id, user.id);
    }

    public void addUserRole(UserRole userRole) {
	if (Objects.isNull(userRoles)) {
	    userRoles = new ArrayList<>();
	}
	userRoles.add(userRole);
    }

    public void removeUserRole(UserRole userRole) {
	if (!Objects.isNull(userRoles) && userRoles.contains(userRole)) {
	    userRoles.remove(userRole);
	}
    }
}
