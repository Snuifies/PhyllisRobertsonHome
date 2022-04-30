package za.org.phyllis.robertson.home.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.org.phyllis.robertson.home.model.ResidentDailyCareDO;
import za.org.phyllis.robertson.home.model.ResidentMealDO;

import java.io.Serializable;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"residentMeal", "message"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ResidentMealResponse implements Serializable {

    @JsonProperty("message")
    private String message;

    @JsonProperty("residentMeal")
    ResidentMealDO residentMeal;
}
