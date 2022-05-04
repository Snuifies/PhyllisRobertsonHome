package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.io.Serializable;

@FieldNameConstants
@Data
//@Audited(withModifiedFlag = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "RESIDENT_CONDITION")
public class ResidentCondition implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONDITION")
    private String condition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESIDENT_ID")
    private Resident resident;


}
