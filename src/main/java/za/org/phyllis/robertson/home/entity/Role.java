package za.org.phyllis.robertson.home.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, name = "ROLE")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(id, role1.id) && Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
