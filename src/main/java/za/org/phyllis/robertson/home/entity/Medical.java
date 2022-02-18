
package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
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




}
