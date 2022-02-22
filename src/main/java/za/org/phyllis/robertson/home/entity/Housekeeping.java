
package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.experimental.FieldNameConstants;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HOUSEKEEPING")
public class Housekeeping extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private String Date;
//    private String WashingRemoved;
//    private String WashingReturned;
//    private String WashingIssue;
//    private String RoomCleaned;
//    private String CleaningIssues;
//    private String MonthlyDeepClean;
//    private String FaultComplaint;
//    private String FaultResolved;

//


}
