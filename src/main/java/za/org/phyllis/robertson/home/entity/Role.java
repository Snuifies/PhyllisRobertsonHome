package za.org.phyllis.robertson.home.entity;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, name = "ROLE")
    private String role;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }


}
