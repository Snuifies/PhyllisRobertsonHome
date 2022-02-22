package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import za.org.phyllis.robertson.home.model.ResidenceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * @author snuif
 */
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Resident")
@Table(name = "RESIDENT")
public class Resident extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @Column(name = "MEDICAL_PLAN")
    private String medicalPlan;

    @Column(name = "MEDICAL_AID_NUMBER")
    private String medicalAidNumber;

    @Column(name = "MEDICAL_AID_PHONE_NUMBER")
    private String medicalAidPhoneNumber;

    @Column(name = "PREFERRED_HOSPITAL")
    private String preferredHospital;

    @Column(name = "DOCTOR")
    private String doctor;

    @Column(name = "DOCTOR_PHONE_NUMBER")
    private String doctorPhoneNumber;

    @Column(name = "AMBULANCE_SERVICE")
    private String ambulanceService;

    @Column(name = "PARENT_GUARDIAN_NAME")
    private String parentGuardianName;

    @Column(name = "PARENT_GUARDIAN_PHONE_NUMBER")
    private String parentGuardianPhoneNumber;

    @Column(name = "PARENT_GUARDIAN_EMAIL")
    private String parentGuardianEmail;

    private int age;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDICAL_ID")
    private Medical medical;

    @OneToMany(
            mappedBy = "resident",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Condition> conditions;

    @OneToMany(
            mappedBy = "resident",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Prescription> prescriptions;

    @OneToMany(
            mappedBy = "resident",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DailyCare> dailyCares;


    public void addCondition(Condition condition) {
        if (Objects.isNull(conditions)) {
            conditions = new ArrayList<>();
        }
        conditions.add(condition);
        condition.setResident(this);
    }

    public void removeCondition(Condition condition) {
        if (!Objects.isNull(conditions) && conditions.contains(condition)) {
            conditions.remove(condition);
            condition.setResident(null);
        }
    }

    public void addPrescription(Prescription prescription) {
        if (Objects.isNull(prescriptions)) {
            prescriptions = new ArrayList<>();
        }
        prescriptions.add(prescription);
        prescription.setResident(this);
    }

    public void removePrescription(Prescription prescription) {
        if (!Objects.isNull(prescriptions) && prescriptions.contains(prescription)) {
            prescriptions.remove(prescription);
            prescription.setResident(null);
        }
    }

    public void addDailyCare(DailyCare dailyCare) {
        if (Objects.isNull(dailyCares)) {
            dailyCares = new ArrayList<>();
        }
        dailyCares.add(dailyCare);
        dailyCare.setResident(this);
    }

    public void removeDailyCare(DailyCare dailyCare) {
        if (!Objects.isNull(dailyCares) && dailyCares.contains(dailyCare)) {
            dailyCares.remove(dailyCare);
            dailyCare.setResident(null);
        }
    }

}
