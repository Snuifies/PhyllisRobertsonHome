package za.org.phyllis.robertson.home.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.org.phyllis.robertson.home.model.RoleDO;
import za.org.phyllis.robertson.home.model.UserDO;

/**
 * @author snuif
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"users", "user", "message"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserResponse implements Serializable {

    @JsonProperty
    private String message;

    @JsonProperty
    List<UserDO> users;

    @JsonProperty
    UserDO user;

    @JsonProperty
    List<RoleDO> roles;

    public List<UserDO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDO> users) {
        this.users = users;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

}
