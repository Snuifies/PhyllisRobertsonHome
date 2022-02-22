package za.org.phyllis.robertson.home.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import lombok.experimental.FieldNameConstants;

/**
 *
 * @author snuif
 */
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Condition")
@Table(name = "CONDITION")
public class Condition extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = -5172178857306870614L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CONDITION")
    private String condition;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Resident resident;

}
