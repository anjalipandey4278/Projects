package com.nagarro.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "email_id", referencedColumnName = "email")
	private List<ProductDetails> products = new ArrayList<ProductDetails>();

	public Admin(String email, String password, List<ProductDetails> products) {
		super();
		this.email = email;
		this.password = password;
		this.products = products;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ProductDetails> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDetails> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", products=" + products + "]";
	}

}
