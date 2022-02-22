package za.org.phyllis.robertson.home.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import za.org.phyllis.robertson.home.model.DietType;
import za.org.phyllis.robertson.home.model.MealType;

/**
 * @author snuif
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FOOD_SERVICES")
public class FoodService extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Resident resident;

    @Column(name = "FOOD_SERVICE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar foodServiceDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "DIET_TYPE")
    private DietType DietType;

    @Column(name = "COMPLAINT_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar ComplaintDate;

    @Column(name = "COMPLAINT_DETAIL")
    private String ComplaintDetail;

    @Column(name = "PLANNED_ABSENCE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar plannedAbsenceDate;

    @Column(name = "MEALS_ABSENT_DETAIL")
    private String MealsAbsentDetail;

    @Column(name = "PACKED_LUNCH_REQUEST_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar PackedLunchRequestedDate;

    @Column(name = "KEPT_LUNCH_REQUEST_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar keptLunchRequestDate;

    @Column(name = "BED_MEAL_REQUEST_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar bedMealRequestDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "BED_MEAL_REQUEST_TYPE")
    private MealType bedMealRequestType;

    @Column(name = "FOOD_NOT_EATEN_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar FoodNotEatenDate;

    @Column(name = "FOOD_NOT_EATEN_DETAIL")
    private String FoodNotEaten;


}
