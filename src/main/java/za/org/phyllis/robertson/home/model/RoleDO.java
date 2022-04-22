package za.org.phyllis.robertson.home.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.org.phyllis.robertson.home.entity.Role;
/**
 *
 * @author snuif
 */
@Data
@Builder
public class RoleDO {

private long id;
private String role;

    public RoleDO(Role role) {
	this.id = role.getId();
	this.role = role.getRole();
    }
    public RoleDO(long id, String role) {
	this.id = id;
	this.role = role;
    }
}
