package za.org.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.org.phyllis.robertson.home.entity.Room;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author snuif
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "roomNumber",
        "available",
        "houseKeepingDate",
        "washingRemovedDate",
        "washingRemovedComment",
        "washingReturnedDate",
        "washingReturnedComment",
        "washingIssueDate",
        "washingIssueComment",
        "roomCleanedDate",
        "roomCleanedComment",
        "cleaningIssuesDate",
        "cleaningIssuesComment",
        "monthlyDeepCleanDate",
        "monthlyDeepCleanComment",
        "faultComplaintDate",
        "faultComplaintComment",
        "faultResolvedDate",
        "faultResolvedComment",
        "description",
        "resident"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RoomDO implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("roomNumber")
    private String roomNumber;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("houseKeepingDate")
    private LocalDate houseKeepingDate;

    @JsonProperty("washingRemovedDate")
    private LocalDate washingRemovedDate;

    @JsonProperty("washingRemovedComment")
    private String washingRemovedComment;

    @JsonProperty("washingReturnedDate")
    private LocalDate washingReturnedDate;

    @JsonProperty("washingReturnedComment")
    private String washingReturnedComment;

    @JsonProperty("washingIssueDate")
    private LocalDate washingIssueDate;

    @JsonProperty("washingIssueComment")
    private String washingIssueComment;

    @JsonProperty("roomCleanedDate")
    private LocalDate roomCleanedDate;

    @JsonProperty("roomCleanedComment")
    private String roomCleanedComment;

    @JsonProperty("cleaningIssuesDate")
    private LocalDate cleaningIssuesDate;

    @JsonProperty("cleaningIssuesComment")
    private String cleaningIssuesComment;

    @JsonProperty("monthlyDeepCleanDate")
    private LocalDate monthlyDeepCleanDate;

    @JsonProperty("monthlyDeepCleanComment")
    private String monthlyDeepCleanComment;

    @JsonProperty("faultComplaintDate")
    private LocalDate faultComplaintDate;

    @JsonProperty("faultComplaintComment")
    private String faultComplaintComment;

    @JsonProperty("faultResolvedDate")
    private LocalDate faultResolvedDate;

    @JsonProperty("faultResolvedComment")
    private String faultResolvedComment;

    @JsonProperty("description")
    private String description;

    @JsonProperty("resident")
    private String resident;

    public RoomDO(Room room) {
        this.roomNumber = room.getRoomNumber();
        this.available = room.isAvailable();
        this.houseKeepingDate = room.getHouseKeepingDate();
        this.washingRemovedDate = room.getWashingRemovedDate();
        this.washingRemovedComment = room.getWashingRemovedComment();
        this.washingReturnedDate = room.getWashingReturnedDate();
        this.washingReturnedComment = room.getWashingReturnedComment();
        this.washingIssueDate = room.getWashingIssueDate();
        this.washingIssueComment = room.getWashingIssueComment();
        this.roomCleanedDate = room.getRoomCleanedDate();
        this.roomCleanedComment = room.getRoomCleanedComment();
        this.cleaningIssuesDate = room.getCleaningIssuesDate();
        this.cleaningIssuesComment = room.getCleaningIssuesComment();
        this.monthlyDeepCleanDate = room.getMonthlyDeepCleanDate();
        this.monthlyDeepCleanComment = room.getMonthlyDeepCleanComment();
        this.faultComplaintDate = room.getFaultComplaintDate();
        this.faultComplaintComment = room.getFaultComplaintComment();
        this.faultResolvedDate = room.getFaultResolvedDate();
        this.faultResolvedComment = room.getFaultResolvedComment();
        this.description = room.getDescription();
        if (room.getResident() != null){
            this.resident = room.getResident().getName();
        }
    }
}
