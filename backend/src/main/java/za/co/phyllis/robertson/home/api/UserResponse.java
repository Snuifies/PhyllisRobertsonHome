package za.co.phyllis.robertson.home.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import za.co.phyllis.robertson.home.model.AppUserModel;

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
	List<AppUserModel> users;

	@JsonProperty
	AppUserModel user;

	@JsonProperty
	List<AppUserModel> roles;

	public List<AppUserModel> getUsers() {
		return users;
	}

	public void setUsers(List<AppUserModel> users) {
		this.users = users;
	}

	public AppUserModel getUser() {
		return user;
	}

	public void setUser(AppUserModel user) {
		this.user = user;
	}

}
