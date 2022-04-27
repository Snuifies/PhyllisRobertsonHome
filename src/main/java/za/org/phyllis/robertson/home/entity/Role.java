package za.org.phyllis.robertson.home.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@Entity(name = "ROLES")
@Table(name = "ROLES")
public class Role implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, name = "ROLE")
    private String role;
}
