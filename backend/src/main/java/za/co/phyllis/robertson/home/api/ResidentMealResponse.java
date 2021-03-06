package  za.co.phyllis.robertson.home.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.phyllis.robertson.home.model.ResidentMealDO;

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
