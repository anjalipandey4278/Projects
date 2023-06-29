package com.nagarro.AdvanceJava2.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="tshirtproduct")
	public class CSVData {
		
        
		@Id
		@Column(name = "USER_ID",unique=true,columnDefinition="VARCHAR(64)")
		String shirt_id;
		
		String product_name;
		String colour;
		String gender;
		String size;
		double price;
		double rating;
		String product_availability;

		public String getShirt_id() {
			return shirt_id;
		}

		public void setShirt_id(String shirt_id) {
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

		public String getProduct_availability() {
			return product_availability;
		}

		public void setProduct_availability(String product_availability) {
			this.product_availability = product_availability;
		}

	}



