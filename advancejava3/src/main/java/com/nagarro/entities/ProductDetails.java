package com.nagarro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductDetails {
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "item_title", nullable = false)
	private String itemTitle;

	@Column(name = "item_quantity", nullable = false)
	private String itemQuantity;

	private String image;
	private String size;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public ProductDetails() {

		// TODO Auto-generated constructor stub
	}

	public ProductDetails(Integer productId, String itemTitle, String itemQuantity, String image) {

		this.productId = productId;
		this.itemTitle = itemTitle;
		this.itemQuantity = itemQuantity;
		this.image = image;
	}

	public ProductDetails(String itemTitle, String itemQuantity, String image) {

		this.itemTitle = itemTitle;
		this.itemQuantity = itemQuantity;
		this.image = image;
	}

}
