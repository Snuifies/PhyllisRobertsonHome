
package za.org.phyllis.robertson.home.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import za.org.phyllis.robertson.home.model.BathType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DAILY_CARE")
public class DailyCare extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Resident resident;

    @Column(name = "CARE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar careDate;

    @Column(name = "CARE_WORKER_ASSIGNED")
    private String careWorkerAssigned;

    @Enumerated(EnumType.STRING)
    @Column(name = "BATH")
    private BathType bath;

    @Column(name = "SHAVED")
    private Boolean shaved;

    @Column(name = "NAILS_CUT")
    private Boolean nailsCut;

    @Column(name = "HEELS_TREATED")
    private Boolean heelsTreated;

    @Column(name = "BED_MADE")
    private Boolean bedMade;

    @Column(name = "CLEAN_LINNEN")
    private Boolean cleanLinnen;

    @Column(name = "WASHING_REMOVED")
    private Boolean washingRemoved;

    @Column(name = "CUPBOARD_PACKED")
    private Boolean cupboardPacked;

    @Column(name = "WHEELCHAIR_CLEANED")
    private Boolean wheelchairCleaned;

    @Column(name = "MEDICATION_MORNING")
    private String medicationMorning;

    @Column(name = "MEDICATION_BREAKFAST")
    private String medicationBreakfast;

    @Column(name = "MEDICATION_LUNCH")
    private String medicationLunch;

    @Column(name = "MEDICATION_SUPPER")
    private String medicationSupper;

    @Column(name = "MEDICATION_EVENING")
    private String medicationEvening;

    @Column(name = "MEDICATION_ACUTE_TIME")
    @Temporal(TemporalType.DATE)
    private Calendar medicationAcuteTime;

    @Column(name = "MEDICATION_ACUTE_ITEM")
    private String medicationAcuteItem;

    @Column(name = "COMPLAINT")
    private String complaint;

    @Column(name = "ACTIONS_ADVISED")
    private String actionsAdvised;


}
