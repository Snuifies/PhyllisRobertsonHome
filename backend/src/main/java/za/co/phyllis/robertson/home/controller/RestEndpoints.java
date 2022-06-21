package za.co.phyllis.robertson.home.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.phyllis.robertson.home.config.ApplicationConfig;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestEndpoints {

	@Autowired
	private final ApplicationConfig config;

	@GetMapping(path = "/version")
	public @ResponseBody
	String getAppVersion() {
		return config.getVersion();
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h2>Welcome Admin!</h2>";
	}

	@GetMapping("/all")
	public String all() {
		return "<h2>Hello One And All!</h2>";
	}

	@GetMapping("/home")
	public String home() {
		return "<h1>Welcome To the Jungle</h1>";
	}

	@GetMapping("/residence")
	public String residence() {
		return "<h1>Welcome To the Residence</h1>";
	}

	@GetMapping("/moderator")
	public String moderator() {
		return "<h1>Welcome Moderator</h1>";
	}

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Products> getProducts() {
		List<Products> products = new ArrayList<>();
		products.add(Products.builder().price(2.0).quantity(5).name("Prod1").description("Product of Type 1").link("https://source.unsplash.com/1600x900/?product").build());
		return products;
	}

}
