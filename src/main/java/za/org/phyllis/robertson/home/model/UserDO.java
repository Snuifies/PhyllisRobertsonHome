package za.org.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.org.phyllis.robertson.home.entity.User;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "username",
        "email",
        "roles"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private String password;
    @JsonProperty("roles")
    private Set<String> roles;

    public UserDO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toSet());
    }

}
