package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author snuif
 */
@Data
@Entity
@Table(name = "FOOD_SERVICES")
public class FoodServices implements Serializable {
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


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
}
