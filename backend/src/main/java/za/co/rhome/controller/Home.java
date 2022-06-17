package za.co.rhome.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// we allow localhost:4200 for testing purposes
@CrossOrigin(origins = "http://localhost:4200")
public class Home {

	@GetMapping("/")
	public String home() {
		return "<h1>Welcome Y'all</h1>";
	}

	@GetMapping("/home")
	public String user() {
		return "<h1>Welcome Homeys</h1>";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}

	@GetMapping("/moderator")
	public String moderator() {
		return "<h1>Welcome Moderator</h1>";
	}

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public Products[] getProducts() {
		List<Products> products = new ArrayList<>();
		products.add(Products.builder().price(2.0).quantity(5).name("Prod1").description("Product of Type 1").link("https://source.unsplash.com/1600x900/?product").build());
		return (Products[]) products.toArray();
	}

}
