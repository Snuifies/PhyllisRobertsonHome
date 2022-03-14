package za.org.phyllis.robertson.home.entity.security;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import za.org.phyllis.robertson.home.entity.Auditable;

@FieldNameConstants
@Data
@Builder
@Entity
@Table(name = "ROLES")
public class Role extends Auditable<Long> implements Serializable {

    public Role() {
    }

    public Role(String role) {
	this.role = role;
    }

    public Role(long id, String role) {
	this.id = id;
	this.role = role;
    }

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, name = "ROLE")
    private String role;

}
