package za.org.phyllis.robertson.home.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

/**
 *
 * @author snuif
 */
@FieldNameConstants
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Room")
@Table(name = "ROOM")
public class Room extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ROOM_NUMBER", unique = true, nullable = false)
    private String roomNumber;

    @Column(name = "AVAILABLE")
    private Boolean available;

    @OneToOne(mappedBy = Resident.Fields.room, fetch = FetchType.LAZY)
    private Resident resident;
}
