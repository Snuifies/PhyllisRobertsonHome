package za.org.phyllis.robertson.home.entity.room;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import za.org.phyllis.robertson.home.entity.Auditable;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@Builder
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @Column(name = "HOUSEKEEPING_DATE")
    private LocalDateTime housekeepingDate;

    @Column(name = "WASHING_REMOVED_DATE")
    private LocalDateTime washingRemovedDate;

    @Column(name = "WASHING_REMOVED_COMMENT")
    private String washingRemovedComment;

    @Column(name = "WASHING_RETURNED_DATE")
    private LocalDateTime washingReturnedDate;

    @Column(name = "WASHING_RETURNED_COMMENT")
    private String washingReturnedComment;

    @Column(name = "WASHING_ISSUE_DATE")
    private LocalDateTime washingIssueDate;

    @Column(name = "WASHING_ISSUE_COMMENT")
    private String washingIssueComment;

    @Column(name = "ROOM_CLEANED_DATE")
    private LocalDateTime roomCleanedDate;

    @Column(name = "ROOM_CLEANED_COMMENT")
    private String roomCleanedComment;

    @Column(name = "CLEANING_ISSUES_COMMENT")
    private String cleaningIssuesComment;

    @Column(name = "MONTHLY_DEEP_CLEAN_DATE")
    private LocalDateTime monthlyDeepCleanDate;

    @Column(name = "MONTHLY_DEEP_CLEAN_COMMENT")
    private String monthlyDeepCleanComment;

    @Column(name = "FAULT_COMPLAINT_DATE")
    private LocalDateTime faultComplaintDate;

    @Column(name = "FAULT_COMPLAINT_COMMENT")
    private String faultComplaintComment;

    @Column(name = "FAULT_RESOLVED_DATE")
    private LocalDateTime faultResolvedDate;

    @Column(name = "FAULT_RESOLVED_COMMENT")
    private String faultResolvedComment;

}
