package za.org.phyllis.robertson.home.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.org.phyllis.robertson.home.model.ResidentDO;

import java.io.Serializable;
import java.util.List;

/**
 * @author snuif
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"residents", "resident", "message"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ResidentResponse implements Serializable {

    @JsonProperty
    private String message;

    @JsonProperty
    List<ResidentDO> residents;

    @JsonProperty
    ResidentDO resident;

}
