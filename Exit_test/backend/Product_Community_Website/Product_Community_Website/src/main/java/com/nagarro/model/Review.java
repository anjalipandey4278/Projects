package com.nagarro.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Review {
	 	 
   @Id
   @GeneratedValue
	    private long id;
	    private String heading;
	    private String review;
	    private int rating;
	    public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		private boolean isapproved;
	   
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "product_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private Product product;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getHeading() {
			return heading;
		}
		public void setHeading(String heading) {
			this.heading = heading;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		public boolean isIsapproved() {
			return isapproved;
		}
		public void setIsapproved(boolean isapproved) {
			this.isapproved = isapproved;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Review(long id, String heading, String review, int rating, boolean isapproved, Product product) {
			super();
			this.id = id;
			this.heading = heading;
			this.review = review;
			this.rating = rating;
			this.isapproved = isapproved;
			this.product = product;
		}
		public Review() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
}
		