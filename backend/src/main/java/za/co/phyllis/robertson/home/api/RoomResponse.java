package za.co.phyllis.robertson.home.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import za.co.phyllis.robertson.home.model.RoomDO;

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
