package za.org.phyllis.robertson.home.entity.security;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import za.org.phyllis.robertson.home.entity.Auditable;

@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS",
	uniqueConstraints = {
	    @UniqueConstraint(columnNames = "USERNAME"),
	    @UniqueConstraint(columnNames = "EMAIL")
	})
public class User extends Auditable<Long> implements Serializable {


    public User(long id, String username, String password, String email) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
    }

    public User(String username, String password, String email) {
	this.username = username;
	this.password = password;
	this.email = email;
    }

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Size(max = 50)
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES",
	    joinColumns = @JoinColumn(name = "USER_ID"),
	    inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
	if (Objects.isNull(roles)) {
	    roles = new HashSet<>();
	}
	roles.add(role);
    }

    public void removeRole(Role role) {
	if (!Objects.isNull(roles) && roles.contains(role)) {
	    roles.remove(role);
	}
    }

}
