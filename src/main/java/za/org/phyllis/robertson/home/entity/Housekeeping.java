
package za.org.phyllis.robertson.home.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.experimental.FieldNameConstants;
import za.org.phyllis.robertson.home.model.BathType;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @Column(name = "HOUSEKEEPING_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar housekeepingDate;

    @Column(name = "WASHING_REMOVED_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar washingRemovedDate;

    @Column(name = "WASHING_REMOVED_COMMENT")
    private String washingRemovedComment;

    @Column(name = "WASHING_RETURNED_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar washingReturnedDate;

    @Column(name = "WASHING_RETURNED_COMMENT")
    private String washingReturnedComment;

    @Column(name = "WASHING_ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar washingIssueDate;

    @Column(name = "WASHING_ISSUE_COMMENT")
    private String washingIssueComment;

    @Column(name = "ROOM_CLEANED_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar  roomCleanedDate;

    @Column(name = "ROOM_CLEANED_COMMENT")
    private String roomCleanedComment;

    @Column(name = "CLEANING_ISSUES_COMMENT")
    private String cleaningIssuesComment;

    @Column(name = "MONTHLY_DEEP_CLEAN_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar monthlyDeepCleanDate;

    @Column(name = "MONTHLY_DEEP_CLEAN_COMMENT")
    private String monthlyDeepCleanComment;

    @Column(name = "FAULT_COMPLAINT_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar  faultComplaintDate;

    @Column(name = "FAULT_COMPLAINT_COMMENT")
    private String faultComplaintComment;

    @Column(name = "FAULT_RESOLVED_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar faultResolvedDate;

    @Column(name = "FAULT_RESOLVED_COMMENT")
    private String faultResolvedComment;


}
