package za.org.phyllis.robertson.home.model;

import za.org.phyllis.robertson.home.entity.Role;
import za.org.phyllis.robertson.home.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import java.util.*;
import java.util.stream.Collectors;

public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<String> roles;

    public UserDO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        Set<Role> roles = user.getRoles();
        this.roles = roles.stream().map(role -> role.getRole()).collect(Collectors.toList());
    }

    public UserDO(Long id, String username, String email, String password,
                  Collection<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        if (Objects.nonNull(roles) && !roles.isEmpty()) {
            this.roles = new ArrayList(roles);
        }
    }

    public static UserDO build(User user) {
        List<String> roles = user.getRoles().stream()
                .map(role -> role.getRole())
                .collect(Collectors.toList());
        return new UserDO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                roles);
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

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
}
