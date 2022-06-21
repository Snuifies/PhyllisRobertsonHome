package za.co.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.phyllis.robertson.home.entity.ResidentCondition;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"condition"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentConditionDO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("condition")
	private String condition;

	public ResidentConditionDO(ResidentCondition condition) {
		this.id = condition.getId();
		this.condition = condition.getCondition();
	}
}
