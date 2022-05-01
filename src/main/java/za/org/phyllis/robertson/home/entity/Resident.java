package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;
import za.org.phyllis.robertson.home.model.ResidenceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Audited(withModifiedFlag = true)
@Entity
@Table(name = "RESIDENT")
public class Resident implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "DOCTOR_VISIT_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar doctorVisitDate;

    @Column(name = "ATTENDING_DOCTOR")
    private String attendingDoctor;

    @Column(name = "ACCOMPANIED_BY")
    private String accompaniedBy;

    @Column(name = "TREATMENT")
    private String treatment;

    @Column(name = "COPY_OF_PRESCRIPTION")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] copyOfPrescription;

    @Column(name = "NEXT_APPOINTMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar nextAppointmentDate;

    @Column(name = "MEDICATION_TO_PHARMACY_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar medicationToPharmacyDate;

    @Column(name = "BLISTERS_RECEIVED_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar blistersReceivedDate;

    @Column(name = "BLISTERS_RECEIVED")
    private int blistersReceived;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @OneToOne(mappedBy = "resident", fetch = FetchType.EAGER)
    private ResidentDailyCare residentDailyCare;

    @OneToOne(mappedBy = "resident", fetch = FetchType.EAGER)
    private ResidentMeal residentMeal;

    //    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToMany(mappedBy = "resident", fetch = FetchType.EAGER)
    private Set<ResidentCondition> conditions = new HashSet<>();

    ////    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToMany(mappedBy = "resident", fetch = FetchType.EAGER)
    private Set<ResidentPrescription> prescriptions = new HashSet<>();


}
