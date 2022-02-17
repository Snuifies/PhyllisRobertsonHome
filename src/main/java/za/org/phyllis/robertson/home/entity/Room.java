package za.org.phyllis.robertson.home.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author snuif
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Room")
@Table(name = "ROOM")
public class Room extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "room", fetch = FetchType.LAZY)
    private Resident resident;
}