package za.org.phyllis.robertson.home.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.org.phyllis.robertson.home.entity.Room;
import za.org.phyllis.robertson.home.model.RoleDO;
import za.org.phyllis.robertson.home.model.RoomDO;
import za.org.phyllis.robertson.home.model.UserDO;

import java.io.Serializable;
import java.util.List;

/**
 * @author snuif
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"users", "user", "message"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoomResponse implements Serializable {

    @JsonProperty
    private String message;

    @JsonProperty
    List<RoomDO> rooms;

    @JsonProperty
    RoomDO room;

}
