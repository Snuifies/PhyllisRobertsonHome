package za.org.phyllis.robertson.home.entity.resident;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import za.org.phyllis.robertson.home.entity.Auditable;
import za.org.phyllis.robertson.home.model.FoodReactionType;

/**
 *
 * @author snuif
 */
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FOOD_PREFERENCE")
public class FoodPreference extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FOOD_CATEGORY")
    private String foodCategory;

    @Column(name = "FOOD_REACTION")
    @Enumerated(EnumType.STRING)
    private FoodReactionType foodReaction;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Resident resident;

}
