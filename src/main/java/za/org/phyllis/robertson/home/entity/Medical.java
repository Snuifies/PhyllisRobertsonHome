package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.experimental.FieldNameConstants;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEDICAL")
public class Medical extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DOCTOR_VISIT_DATE")
    private Date DoctorVisitDate;

    @Column(name = "DOCTOR_ATTENDED")
    private String DoctorAttended;

    @Column(name = "ACCOMPANIED_BY")
    private String AccompaniedBy;

    @Column(name = "TREATMENT")
    private String Treatment;

    @Column(name = "COPY_OF_PRESCRIPTION")
    private Byte[] CopyOfPrescription;

    @Column(name = "NEXT_APPOINTMENT")
    private Date NextAppointment;

    @Column(name = "MEDICATION_TO_PHARMACY_DATE")
    private Date MedicationToPharmacyDate;

    @Column(name = "BLISTERS_RECEIVED_DATE")
    private Date BlistersReceivedDate;

    @Column(name = "BLISTERS_RECEIVED")
    private int BlistersReceived;

    @OneToOne(mappedBy = Resident.Fields.medical, fetch = FetchType.LAZY)
    private Resident resident;

 }
