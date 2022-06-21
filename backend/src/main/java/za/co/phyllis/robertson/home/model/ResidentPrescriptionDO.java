package za.co.phyllis.robertson.home.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.phyllis.robertson.home.entity.ResidentPrescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"prescription",
	"itemSent",
	"quantitySent",
	"prescriptionDueForRenewal"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentPrescriptionDO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("prescription")
	private String prescription;

	@JsonProperty("dose")
	private String dose;

	@JsonProperty("itemSent")
	private String itemSent;

	@JsonProperty("quantitySent")
	private int quantitySent;

	@JsonProperty("prescriptionDueForRenewal")
	private Boolean prescriptionDueForRenewal;

	public ResidentPrescriptionDO(ResidentPrescription prescription) {
		this.id = prescription.getId();
		this.prescription = prescription.getPrescription();
		this.dose = prescription.getDose();
		this.itemSent = prescription.getItemSent();
		this.quantitySent = prescription.getQuantitySent();
		this.prescriptionDueForRenewal = prescription.getPrescriptionDueForRenewal();
	}
}
