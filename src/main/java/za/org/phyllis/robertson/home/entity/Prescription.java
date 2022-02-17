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

/**
 * @author snuif
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRESCRIPTION")
public class Prescription extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
