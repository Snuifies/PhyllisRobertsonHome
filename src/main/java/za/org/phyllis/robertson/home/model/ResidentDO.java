package za.org.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import za.org.phyllis.robertson.home.entity.Resident;
import za.org.phyllis.robertson.home.entity.Room;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

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
    private String room;

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
//        if (resident.getRoom() != null) {
//            this.room = resident.getRoom().getRoomNumber();
//        }

    }
}
