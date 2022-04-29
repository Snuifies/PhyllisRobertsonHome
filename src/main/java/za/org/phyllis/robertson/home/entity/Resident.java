package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.envers.Audited;
import za.org.phyllis.robertson.home.model.ResidenceType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@Entity(name = "RESIDENT")
@Table(name = "RESIDENT")
public class Resident implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;


    @Id
    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Calendar dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESIDENCE_TYPE")
    private ResidenceType residenceType;

    @Column(name = "MEDICAL_AID_NAME")
    private String medicalAidName;

    @Column(name = "MEDICAL_AID_PLAN")
    private String medicalAidPlan;

    @Column(name = "MEDICAL_AID_NUMBER")
    private String medicalAidNumber;

    @Column(name = "MEDICAL_AID_PHONE_NUMBER")
    private String medicalAidPhoneNumber;

    @Column(name = "PREFERRED_HOSPITAL")
    private String preferredHospital;

    @Column(name = "HOUSE_DOCTOR")
    private String houseDoctor;

    @Column(name = "HOUSE_DOCTOR_PHONE_NUMBER")
    private String houseDoctorPhoneNumber;

    @Column(name = "AMBULANCE_SERVICE")
    private String ambulanceService;

    @Column(name = "PARENT_GUARDIAN_NAME")
    private String parentGuardianName;

    @Column(name = "PARENT_GUARDIAN_PHONE_NUMBER")
    private String parentGuardianPhoneNumber;

    @Column(name = "PARENT_GUARDIAN_EMAIL")
    private String parentGuardianEmail;

//    @MapsId
//    @OneToOne
//    @JoinColumn(name = Room.Fields.roomNumber)
//   private Room room;

}
