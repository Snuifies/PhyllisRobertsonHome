package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author snuif
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Resident")
@Table(name = "RESIDENT")
public class Resident extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NICK_NAME")
    private String nickName;

//
//    @Column(name = "DATE_OF_BIRTH")
//    @Temporal(TemporalType.DATE)
//    private Date dateOfBirth;
//
//    @Column(name = "AGE")
//    private int age;
//
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "RESIDENCE_TYPE")
//    private ResidenceType residenceType;
//
//    @Column(name = "MEDICAL_AID")
//    private String medicalAid;
//
//    @Column(name = "MEDICAL_AID_NUMBER")
//    private String MedicalAidNumber;
//
//    @Column(name = "PREFERRED_HOSPITAL")
//    private String preferredHospital;
//
//    @Column(name = "DOCTOR")
//    private String doctor;
//
//    @Column(name = "PARENT_GUARDIAN_NAME")
//    private String contactDetails;
//
//    @Column(name = "PARENT_GUARDIAN_NAME")
//    private String ambulanceService;
//
//    @Column(name = "PARENT_GUARDIAN_NAME")
//    private String parentGuardianName;
//
//    @Column(name = "PARENT_GUARDIAN_PHONE_NUMBER")
//    private String parentGuardianPhoneNumber;
//
//    @Column(name = "PARENT_GUARDIAN_EMAIL")
//    private String parentGuardianEmail;


 
    @MapsId
    @OneToOne
    @JoinColumn(name = "ID")
    private Room room;

}
