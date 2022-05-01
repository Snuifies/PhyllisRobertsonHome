package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Audited(withModifiedFlag = true)
@Entity//(name = "ROLES")
@Table(name = "ROLES")
public class Role implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, name = "ROLE")
    private String role;
}
