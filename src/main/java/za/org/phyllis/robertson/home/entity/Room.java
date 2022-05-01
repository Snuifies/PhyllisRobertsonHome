package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author snuif
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Audited(withModifiedFlag = true)
@Entity
@Table(name = "ROOM")
public class Room implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "AVAILABLE")
    private boolean available;

    @Column(name = "HOUSE_KEEPING_DATE")
    private LocalDate houseKeepingDate;

    @Column(name = "WASHING_REMOVED_DATE")
    private LocalDate WashingRemovedDate;

    @Column(name = "WASHING_REMOVED_COMMENT")
    private String WashingRemovedComment;

    @Column(name = "WASHING_RETURNED_DATE")
    private LocalDate WashingReturnedDate;

    @Column(name = "WASHING_RETURNED_COMMENT")
    private String WashingReturnedComment;

    @Column(name = "WASHING_ISSUE_DATE")
    private LocalDate WashingIssueDate;

    @Column(name = "WASHING_ISSUE_COMMENT")
    private String WashingIssueComment;

    @Column(name = "ROOM_CLEANED_DATE")
    private LocalDate RoomCleanedDate;

    @Column(name = "ROOM_CLEANED_COMMENT")
    private String RoomCleanedComment;

    @Column(name = "CLEANING_ISSUES_DATE")
    private LocalDate CleaningIssuesDate;

    @Column(name = "CLEANING_ISSUES_COMMENT")
    private String CleaningIssuesComment;

    @Column(name = "MONTHLY_DEEP_CLEAN_DATE")
    private LocalDate MonthlyDeepCleanDate;

    @Column(name = "MONTHLY_DEEP_CLEAN_COMMENT")
    private String MonthlyDeepCleanComment;

    @Column(name = "FAULT_COMPLAINT_DATE")
    private LocalDate FaultComplaintDate;

    @Column(name = "FAULT_COMPLAINT_COMMENT")
    private String FaultComplaintComment;

    @Column(name = "FAULT_RESOLVED_DATE")
    private LocalDate FaultResolvedDate;

    @Column(name = "FAULT_RESOLVED_COMMENT")
    private String FaultResolvedComment;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(mappedBy = "room", fetch = FetchType.LAZY)
    private Resident resident;

}
