package za.org.phyllis.robertson.home.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.org.phyllis.robertson.home.model.ResidentConditionDO;
import za.org.phyllis.robertson.home.model.ResidentDailyCareDO;

import java.io.Serializable;
import java.util.List;

/**
 * @author snuif
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"conditions", "condition", "message"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ResidentConditionResponse implements Serializable {

    @JsonProperty
    private String message;

    @JsonProperty
    List<ResidentConditionDO> conditions;

    @JsonProperty
    ResidentConditionDO condition;
}
