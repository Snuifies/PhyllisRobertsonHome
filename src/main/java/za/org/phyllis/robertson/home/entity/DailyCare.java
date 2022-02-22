
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
@Table(name = "DAILY_CARE")
public class DailyCare extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Temporal(TemporalType.DATE)
//    private String Date;
//    private String CareWorkerAssigned;
//    private String Bath; ///shower/bedbath
//    private String Shaved;
//    private String NailsCut;
//    private String HeelsTreated;
//    private String BedMade;
//    private String CleanLinnen;
//    private String WashningRemoved;
//    private String CupboardPacked;
//    private String WheelchairCleaned;
//    private String MedicationMorning;
//    private String MedicationBreakfast;
//    private String MedicationLunch;
//    private String MedicationSupper;
//    private String MedicationEvening;
//    private String MedicationAcuteTime;
//    private String MedicationAacuteItem;
//    private String Complaint;
//    private String ActionsAdvised;


}
