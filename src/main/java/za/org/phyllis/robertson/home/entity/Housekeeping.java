
package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author snuif
 */
@Data
@Entity
@Table(name = "HOUSEKEEPING")
public class Housekeeping implements Serializable {
    @Id
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
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

}
