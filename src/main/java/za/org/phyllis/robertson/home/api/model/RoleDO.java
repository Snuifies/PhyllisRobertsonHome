package za.org.phyllis.robertson.home.api.model;



import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import za.org.phyllis.robertson.home.entity.security.Role;

@Data
@Builder
public class RoleDO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String role;

    public RoleDO(Role role) {
	this(role.getId(),
		role.getRole());
    }

    public RoleDO(Long id, String role) {
	this.id = id;
	this.role = role;
    }
}
