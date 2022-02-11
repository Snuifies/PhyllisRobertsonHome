
package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author snuif
 */
@Data
@Entity
@Table(name = "MEDICAL")
public class Medical implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private Date DoctorVisitDate;
//    private String DoctorAttended;
//    private String AccompaniedBy;
//    private String Treatment;
//    private String Prescription;
//    private String Dose;
//    private Byte[] CopyOfPrescription;
//    private Date NextAppointment;
//    private Date MedicationToPharmacy;
//    private String ItemSent;
//    private int QuantitySent;
//    private Date BlistersReceivedDate;
//    private int BlistersReceived;
//    private Boolean MedicineDueForRenewal;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

}
