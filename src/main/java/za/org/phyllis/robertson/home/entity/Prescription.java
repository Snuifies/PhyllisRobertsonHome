package za.org.phyllis.robertson.home.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author snuif
 */
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Audited(withModifiedFlag = true)
@Entity//(name = "PRESCRIPTION")
@Table(name = "PRESCRIPTION")
public class Prescription implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRESCRIPTION")
    private String prescription;

    @Column(name = "DOSE")
    private String dose;

    @Column(name = "ITEM_SENT")
    private String itemSent;

    @Column(name = "QUANTITY_SENT")
    private int quantitySent;

    @Column(name = "PRESCRIPTION_DUE_FOR_RENEWAL")
    private Boolean prescriptionDueForRenewal;

}
