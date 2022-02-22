package za.org.phyllis.robertson.home.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "PRESCRIPTION")
public class Prescription extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRESCRIPTION")
    private String prescription;

    @Column(name = "DOSE")
    private String dose;

    @Column(name = "ITEM_SENT")
    private String itemSent;

    @Column(name = "QUANTITY_SENT")
    private int QuantitySent;

    @Column(name = "PRESCRIPTION_DUE_FOR_RENEWAL")
    private Boolean PrescriptionDueForRenewal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Resident resident;

}
