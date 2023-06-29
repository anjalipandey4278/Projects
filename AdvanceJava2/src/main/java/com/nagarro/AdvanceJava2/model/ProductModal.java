package com.nagarro.AdvanceJava2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

//class for sorting and getting product details

public class ProductModal {
	private String shirt_id;
	private String product_name;
	private String colour;
	private String gender;
	private String size;
	private double price;
	private double rating;
	private String product_availability;

	public ProductModal(String shirt_id, String product_name, String colour, String gender, String size,
			double price, double rating, String product_availability) {
		this.shirt_id = shirt_id;
		this.product_name = product_name;
		this.colour = colour;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.product_availability=product_availability;
	}

	public String getshirt_id() {
		return shirt_id;
	}

	public void setshirt_id(String shirt_id) {
		this.shirt_id = shirt_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getproduct_availability() {
		return product_availability;
	}

	public void setRating(String product_availability) {
		this.product_availability = product_availability;
	}
	
}
