package za.org.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.org.phyllis.robertson.home.entity.ResidentDailyCare;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "careDate",
        "careWorkerAssigned",
        "bath",
        "shaved",
        "nailsCut",
        "heelsTreated",
        "bedMade",
        "cleanLinen",
        "washingRemoved",
        "cupboardPacked",
        "wheelchairCleaned",
        "medicationMorning",
        "medicationBreakfast",
        "medicationLunch",
        "medicationSupper",
        "medicationEvening",
        "medicationAcuteTime",
        "medicationAcuteItem",
        "complaint",
        "actionsAdvised"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentDailyCareDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private long id;

    @JsonProperty("careDate")
    private Calendar careDate;

    @JsonProperty("careWorkerAssigned")
    private String careWorkerAssigned;

    @JsonProperty("bath")
    private BathType bath;

    @JsonProperty("shaved")
    private Boolean shaved;

    @JsonProperty("nailsCut")
    private Boolean nailsCut;

    @JsonProperty("heelsTreated")
    private Boolean heelsTreated;

    @JsonProperty("bedMade")
    private Boolean bedMade;

    @JsonProperty("cleanLinen")
    private Boolean cleanLinen;

    @JsonProperty("washingRemoved")
    private Boolean washingRemoved;

    @JsonProperty("cupboardPacked")
    private Boolean cupboardPacked;

    @JsonProperty("wheelchairCleaned")
    private Boolean wheelchairCleaned;

    @JsonProperty("medicationMorning")
    private String medicationMorning;

    @JsonProperty("medicationBreakfast")
    private String medicationBreakfast;

    @JsonProperty("medicationLunch")
    private String medicationLunch;

    @JsonProperty("medicationSupper")
    private String medicationSupper;

    @JsonProperty("medicationEvening")
    private String medicationEvening;

    @JsonProperty("medicationAcuteTime")
    private Date medicationAcuteTime;

    @JsonProperty("medicationAcuteItem")
    private String medicationAcuteItem;

    @JsonProperty("complaint")
    private String complaint;

    @JsonProperty("actionsAdvised")
    private String actionsAdvised;

    public ResidentDailyCareDO(ResidentDailyCare residentDailyCare) {
        this.id = residentDailyCare.getId();
        this.careDate = residentDailyCare.getCareDate();
        this.careWorkerAssigned = residentDailyCare.getCareWorkerAssigned();
        this.bath = residentDailyCare.getBath();
        this.shaved = residentDailyCare.getShaved();
        this.nailsCut = residentDailyCare.getNailsCut();
        this.heelsTreated = residentDailyCare.getHeelsTreated();
        this.bedMade = residentDailyCare.getBedMade();
        this.cleanLinen = residentDailyCare.getCleanLinen();
        this.washingRemoved = residentDailyCare.getWashingRemoved();
        this.cupboardPacked = residentDailyCare.getCupboardPacked();
        this.wheelchairCleaned = residentDailyCare.getWheelchairCleaned();
        this.medicationMorning = residentDailyCare.getMedicationMorning();
        this.medicationBreakfast = residentDailyCare.getMedicationBreakfast();
        this.medicationLunch = residentDailyCare.getMedicationLunch();
        this.medicationSupper = residentDailyCare.getMedicationSupper();
        this.medicationEvening = residentDailyCare.getMedicationEvening();
        this.medicationAcuteTime = residentDailyCare.getMedicationAcuteTime();
        this.medicationAcuteItem = residentDailyCare.getMedicationAcuteItem();
        this.complaint = residentDailyCare.getComplaint();
        this.actionsAdvised = residentDailyCare.getActionsAdvised();
    }

}
