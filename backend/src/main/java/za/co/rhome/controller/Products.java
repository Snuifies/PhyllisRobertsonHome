/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.rhome.controller;

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
