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
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "CONDITION")
@Table(name = "CONDITION")
public class ResidentCondition implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONDITION")
    private String condition;

}
