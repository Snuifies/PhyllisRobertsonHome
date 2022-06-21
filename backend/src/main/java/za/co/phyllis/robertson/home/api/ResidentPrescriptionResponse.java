package  za.co.phyllis.robertson.home.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.phyllis.robertson.home.model.ResidentPrescriptionDO;

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
public class ResidentPrescriptionResponse implements Serializable {

    @JsonProperty
    private String message;

    @JsonProperty
    List<ResidentPrescriptionDO> prescriptions;

    @JsonProperty
    ResidentPrescriptionDO prescription;
}
