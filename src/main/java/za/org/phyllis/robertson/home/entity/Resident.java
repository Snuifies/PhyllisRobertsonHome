package za.org.phyllis.robertson.home.entity;

import lombok.Data;
import za.org.phyllis.robertson.home.model.ResidenceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author snuif
 */
@Data
@Entity(name = "Resident")
@Table(name = "RESIDENT")
public class Resident implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//
//    @Column(name = "ID_NUMBER")
//    private String idNumber;
//
//    @Column(name = "NAME")
//    private String name;
//
//    @Column(name = "NICK_NAME")
//    private String nickName;
//
//    @Column(name = "DATE_OF_BIRTH")
//    @Temporal(TemporalType.DATE)
//    private Date dateOfBirth;
//
//    @Column(name = "AGE")
//    private int age;
//
//    @Column(name = "ROOM")
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Room room;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "RESIDENCE_TYPE")
//    private ResidenceType residenceType;
//
//    @Column(name = "CONDITIONS")
//    private Set<Condition> conditions;
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


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

}
