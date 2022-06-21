package za.co.phyllis.robertson.home.model;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author snuif
 */
@Data
@Builder
public class Products {

	int id;
	String name;
	String description;
	double price;
	String link;
	int quantity;
}
