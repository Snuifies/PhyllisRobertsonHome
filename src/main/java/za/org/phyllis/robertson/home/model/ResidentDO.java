package za.org.phyllis.robertson.home.model;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentDO implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;
    private String idNumber;
    private String name;
    private String nickName;
    private Calendar dateOfBirth;
    private ResidenceType residenceType;
    private String medicalAidName;
    private String medicalAidPlan;
    private String medicalAidNumber;
    private String medicalAidPhoneNumber;
    private String preferredHospital;
    private String houseDoctor;
    private String houseDoctorPhoneNumber;
    private String ambulanceService;
    private String parentGuardianName;
    private String parentGuardianPhoneNumber;
    private String parentGuardianEmail;
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
        if (resident.getRoom() != null) {
            this.room = resident.getRoom().getRoomNumber();
        }

    }
}
