package za.org.phyllis.robertson.home.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
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

    @OneToMany(
            mappedBy = "room",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Housekeeping> housekeepings;


    public void addHousekeeping(Housekeeping housekeeping) {
        if (Objects.isNull(housekeepings)) {
            housekeepings = new ArrayList<>();
        }
        housekeepings.add(housekeeping);
        housekeeping.setRoom(this);
    }

    public void removeHousekeeping(Housekeeping housekeeping) {
        if (!Objects.isNull(housekeepings) && housekeepings.contains(housekeeping)) {
            housekeepings.remove(housekeeping);
            housekeeping.setRoom(null);
        }
    }

}
