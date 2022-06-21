package za.co.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import za.co.phyllis.robertson.home.entity.AppRole;

/**
 * @author snuif
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"role"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RoleDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("role")
	private String role;

	public RoleDO(AppRole role) {
		this(role.getRoleId(),
			role.getRoleName());
	}

}
