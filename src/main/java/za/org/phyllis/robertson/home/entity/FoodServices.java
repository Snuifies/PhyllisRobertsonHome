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

/**
 * @author snuif
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FOOD_SERVICES")
public class FoodServices  extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private String Allergies;
//    private String DietType;
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
