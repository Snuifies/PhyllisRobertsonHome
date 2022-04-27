package za.org.phyllis.robertson.home.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import za.org.phyllis.robertson.home.entity.Role;

/**
 * @author snuif
 */
@NoArgsConstructor
@AllArgsConstructor
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

}
