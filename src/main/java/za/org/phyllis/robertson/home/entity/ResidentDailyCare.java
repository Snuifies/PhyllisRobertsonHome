
package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.envers.Audited;
import za.org.phyllis.robertson.home.model.BathType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "RESIDENT_DAILY_CARE")
@Table(name = "RESIDENT_DAILY_CARE")
public class ResidentDailyCare implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    private Long id;

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

    @Column(name = "CLEAN_LINEN")
    private Boolean cleanLinen;

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
    @Temporal(TemporalType.TIME)
    private Date medicationAcuteTime;

    @Column(name = "MEDICATION_ACUTE_ITEM")
    private String medicationAcuteItem;

    @Column(name = "COMPLAINT")
    private String complaint;

    @Column(name = "ACTIONS_ADVISED")
    private String actionsAdvised;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
   private Resident resident;

}
