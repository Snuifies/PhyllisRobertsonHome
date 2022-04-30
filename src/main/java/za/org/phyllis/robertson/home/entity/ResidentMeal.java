package za.org.phyllis.robertson.home.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.envers.Audited;
import za.org.phyllis.robertson.home.model.DietType;
import za.org.phyllis.robertson.home.model.MealType;

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
@Builder
@Audited(withModifiedFlag = true)
@Entity(name = "RESIDENT_MEAL")
@Table(name = "RESIDENT_MEAL")
public class ResidentMeal implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "FOOD_SERVICE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar foodServiceDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "DIET_TYPE")
    private DietType dietType;

    @Column(name = "COMPLAINT_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar complaintDate;

    @Column(name = "COMPLAINT_DETAIL")
    private String complaintDetail;

    @Column(name = "PLANNED_ABSENCE_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar plannedAbsenceDate;

    @Column(name = "MEALS_ABSENT_DETAIL")
    private String mealsAbsentDetail;

    @Column(name = "PACKED_LUNCH_REQUEST_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar packedLunchRequestDate;

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
    private Calendar foodNotEatenDate;

    @Column(name = "FOOD_NOT_EATEN_DETAIL")
    private String foodNotEatenDetail;

    @OneToOne(mappedBy = "room")
    private Resident resident;

}
