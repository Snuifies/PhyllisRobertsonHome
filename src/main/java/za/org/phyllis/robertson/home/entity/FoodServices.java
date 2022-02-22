package za.org.phyllis.robertson.home.entity;

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

/**
 * @author snuif
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FOOD_SERVICES")
public class FoodServices extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FOOD_SERVICE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar foodServiceDate;

//    private String Allergies;
//    private DietType DietType;
//    private String Dislikes;
//    private String Avoid;
//    private String Preference;
//    private String ComplaintDate;
//    private String ComplaintDetail;
//    private String DatePlannedAbsence;
//    private String MealsAbsent;
//    private String PackedLunchRequest;
//    private String KeptLunchRequest;
//    private String BedMealRequest;
//    private String FoodNotEaten;



}
