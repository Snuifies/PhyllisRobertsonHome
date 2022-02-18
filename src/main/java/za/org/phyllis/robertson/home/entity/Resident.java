package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @OneToMany(
	    mappedBy = "resident",
	    cascade = CascadeType.ALL,
	    orphanRemoval = true
    )
    private List<Conditions> conditions;
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

    public void addCondition(Conditions condition) {
	if (Objects.isNull(conditions)) {
	    conditions = new ArrayList<>();
	}
	conditions.add(condition);
	condition.setResident(this);
    }

    public void removeCondition(Conditions condition) {
	if (!Objects.isNull(conditions) && conditions.contains(condition)) {
	    conditions.remove(condition);
	    condition.setResident(null);
	}
    }
}
