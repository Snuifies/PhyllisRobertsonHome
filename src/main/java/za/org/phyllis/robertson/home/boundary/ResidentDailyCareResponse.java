package za.org.phyllis.robertson.home.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.org.phyllis.robertson.home.model.ResidentDailyCareDO;

import java.io.Serializable;

/**
 * @author snuif
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"dailyCare", "message"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ResidentDailyCareResponse implements Serializable {

    @JsonProperty
    private String message;

    @JsonProperty
    ResidentDailyCareDO dailyCare;

}
