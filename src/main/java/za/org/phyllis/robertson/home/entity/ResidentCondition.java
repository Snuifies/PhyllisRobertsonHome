package za.org.phyllis.robertson.home.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
//@Audited(withModifiedFlag = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "RESIDENT_CONDITION")
@Table(name = "RESIDENT_CONDITION")
public class ResidentCondition implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "CONDITION")
    private String condition;

    @ManyToOne
    @JoinColumn(name = "RESIDENT_ROOM_NUMBER")
    private Resident resident;

}
