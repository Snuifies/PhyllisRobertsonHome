package za.org.phyllis.robertson.home.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.org.phyllis.robertson.home.entity.ResidentMeal;

import java.io.Serializable;
import java.util.Calendar;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "roomNumber",
        "foodServiceDate",
        "dietType",
        "complaintDate",
        "complaintDetail",
        "plannedAbsenceDate",
        "mealsAbsentDetail",
        "mealsAbsentDetail",
        "packedLunchRequestedDate",
        "keptLunchRequestDate",
        "bedMealRequestDate",
        "foodNotEatenDate",
        "foodNotEatenDetail"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentMealDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("roomNumber")
    private String roomNumber;
    @JsonProperty("foodServiceDate")
    private Calendar foodServiceDate;
    @JsonProperty("dietType")
    private DietType dietType;
    @JsonProperty("complaintDate")
    private Calendar complaintDate;
    @JsonProperty("complaintDetail")
    private String complaintDetail;
    @JsonProperty("plannedAbsenceDate")
    private Calendar plannedAbsenceDate;
    @JsonProperty("mealsAbsentDetail")
    private String mealsAbsentDetail;
    @JsonProperty("packedLunchRequestDate")
    private Calendar packedLunchRequestDate;
    @JsonProperty("keptLunchRequestDate")
    private Calendar keptLunchRequestDate;
    @JsonProperty("bedMealRequestDate")
    private Calendar bedMealRequestDate;
    @JsonProperty("bedMealRequestType")
    private MealType bedMealRequestType;
    @JsonProperty("foodNotEatenDate")
    private Calendar foodNotEatenDate;
    @JsonProperty("foodNotEatenDetail")
    private String foodNotEatenDetail;

    public ResidentMealDO(ResidentMeal meal) {
        this.roomNumber = meal.getRoomNumber();
        this.foodServiceDate = meal.getFoodServiceDate();
        this.dietType = meal.getDietType();
        this.complaintDate = meal.getComplaintDate();
        this.complaintDetail = meal.getComplaintDetail();
        this.plannedAbsenceDate = meal.getPlannedAbsenceDate();
        this.mealsAbsentDetail = meal.getMealsAbsentDetail();
        this.packedLunchRequestDate = meal.getPackedLunchRequestDate();
        this.keptLunchRequestDate = meal.getKeptLunchRequestDate();
        this.bedMealRequestDate = meal.getBedMealRequestDate();
        this.bedMealRequestType = meal.getBedMealRequestType();
        this.foodNotEatenDate = meal.getFoodNotEatenDate();
        this.foodNotEatenDetail = meal.getFoodNotEatenDetail();
    }
}
