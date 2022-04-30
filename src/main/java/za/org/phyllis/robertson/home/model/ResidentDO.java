package za.org.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.org.phyllis.robertson.home.entity.Resident;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author snuif
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idNumber",
        "name",
        "nickName",
        "dateOfBirth",
        "residenceType",
        "medicalAidName",
        "medicalAidPlan",
        "medicalAidNumber",
        "medicalAidPhoneNumber",
        "preferredHospital",
        "houseDoctor",
        "houseDoctorPhoneNumber",
        "ambulanceService",
        "parentGuardianName",
        "parentGuardianPhoneNumber",
        "parentGuardianEmail",
        "doctorVisitDate",
        "attendingDoctor",
        "accompaniedBy",
        "treatment",
        "nextAppointment",
        "medicationToPharmacyDate",
        "blistersReceivedDate",
        "blistersReceived",
        "prescriptions",
        "conditions",
        "residentDailyCare",
        "residentMeal",
        "room"
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentDO implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @JsonProperty("idNumber")
    private String idNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nickName")
    private String nickName;
    @JsonProperty("dateOfBirth")
    private Calendar dateOfBirth;
    @JsonProperty("residenceType")
    private ResidenceType residenceType;
    @JsonProperty("medicalAidName")
    private String medicalAidName;
    @JsonProperty("medicalAidPlan")
    private String medicalAidPlan;
    @JsonProperty("medicalAidNumber")
    private String medicalAidNumber;
    @JsonProperty("medicalAidPhoneNumber")
    private String medicalAidPhoneNumber;
    @JsonProperty("preferredHospital")
    private String preferredHospital;
    @JsonProperty("houseDoctor")
    private String houseDoctor;
    @JsonProperty("houseDoctorPhoneNumber")
    private String houseDoctorPhoneNumber;
    @JsonProperty("ambulanceService")
    private String ambulanceService;
    @JsonProperty("parentGuardianName")
    private String parentGuardianName;
    @JsonProperty("parentGuardianPhoneNumber")
    private String parentGuardianPhoneNumber;
    @JsonProperty("parentGuardianEmail")
    private String parentGuardianEmail;
    @JsonProperty("room")
    private RoomDO room;
    @JsonProperty("residentDailyCare")
    private ResidentDailyCareDO residentDailyCare;
    @JsonProperty("residentMeal")
    private ResidentMealDO residentMeal;
    @JsonProperty("doctorVisitDate")
    private Calendar doctorVisitDate;
    @JsonProperty("attendingDoctor")
    private String attendingDoctor;
    @JsonProperty("accompaniedBy")
    private String accompaniedBy;
    @JsonProperty("treatment")
    private String treatment;
    @JsonProperty("copyOfPrescription")
    private Byte[] copyOfPrescription;
    @JsonProperty("nextAppointment")
    private Calendar nextAppointment;
    @JsonProperty("medicationToPharmacyDate")
    private Calendar medicationToPharmacyDate;
    @JsonProperty("blistersReceivedDate")
    private Calendar blistersReceivedDate;
    @Column(name = "blistersReceived")
    private int blistersReceived;
    @Column(name = "conditions")
    private Set<ResidentConditionDO> conditions = new HashSet<>();
    @Column(name = "prescriptions")
    private Set<PrescriptionDO> prescriptions = new HashSet<>();

    public ResidentDO(Resident resident) {
        this.idNumber = resident.getIdNumber();
        this.name = resident.getName();
        this.nickName = resident.getNickName();
        this.dateOfBirth = resident.getDateOfBirth();
        this.residenceType = resident.getResidenceType();
        this.medicalAidName = resident.getMedicalAidName();
        this.medicalAidPlan = resident.getMedicalAidPlan();
        this.medicalAidNumber = resident.getMedicalAidNumber();
        this.medicalAidPhoneNumber = resident.getMedicalAidPhoneNumber();
        this.preferredHospital = resident.getPreferredHospital();
        this.houseDoctor = resident.getHouseDoctor();
        this.houseDoctorPhoneNumber = resident.getHouseDoctorPhoneNumber();
        this.ambulanceService = resident.getAmbulanceService();
        this.parentGuardianName = resident.getParentGuardianName();
        this.parentGuardianPhoneNumber = resident.getParentGuardianPhoneNumber();
        this.parentGuardianEmail = resident.getParentGuardianEmail();
        this.doctorVisitDate = resident.getDoctorVisitDate();
        this.doctorVisitDate = resident.getDoctorVisitDate();
        this.attendingDoctor = resident.getAttendingDoctor();
        this.accompaniedBy = resident.getAccompaniedBy();
        this.treatment = resident.getTreatment();
        this.copyOfPrescription = resident.getCopyOfPrescription();
        this.nextAppointment = resident.getNextAppointment();
        this.medicationToPharmacyDate = resident.getMedicationToPharmacyDate();
        this.blistersReceivedDate = resident.getBlistersReceivedDate();
        this.blistersReceived = resident.getBlistersReceived();
        if (!Objects.isNull(resident.getRoom())) {
            this.room = new RoomDO(resident.getRoom());
        }
//        if (!Objects.isNull(resident.getResidentDailyCare())) {
//            this.residentDailyCare = new ResidentDailyCareDO(resident.getResidentDailyCare());
//        }
//        if (!Objects.isNull(resident.getResidentMeal())) {
//            this.residentMeal = new ResidentMealDO(resident.getResidentMeal());
//        }
//        if (!Objects.isNull(resident.getConditions())) {
//            conditions.addAll(
//                    resident.getConditions().stream().map(ResidentConditionDO::new).collect(Collectors.toSet()));
//        }
//        if (!Objects.isNull(resident.getPrescriptions())) {
//            prescriptions.addAll(
//                    resident.getPrescriptions().stream().map(PrescriptionDO::new).collect(Collectors.toSet()));
//        }

    }
}
