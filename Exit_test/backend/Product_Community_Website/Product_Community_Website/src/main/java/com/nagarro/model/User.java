package com.nagarro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
	@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
	public class User {
		

		    @Id
		    @GeneratedValue
		    private Long userid;
		    @Column(name = "first_name")
		    private String firstName;
		    @Column(name = "last_name")
		    private String lastName;
		    private String email;
		    private String password;
		    private boolean activeUser;
		    private String role;
		    
		   
		    
		    public User() {
				super();
				// TODO Auto-generated constructor stub
			}
			public Long getUserid() {
				return userid;
			}
			public void setUserid(Long userid) {
				this.userid = userid;
			}
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lastName) {
				this.lastName = lastName;
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
			public boolean isActiveUser() {
				return activeUser;
			}
			public void setActiveUser(boolean activeUser) {
				this.activeUser = activeUser;
			}
			public String getRole() {
				return role;
			}
			public void setRole(String role) {
				this.role = role;
			}
			public User(Long userid, String firstName, String lastName, String email, String password,
					boolean activeUser, String role) {
				super();
				this.userid = userid;
				this.firstName = firstName;
				this.lastName = lastName;
				this.email = email;
				this.password = password;
				this.activeUser = activeUser;
				this.role = role;
			}
		
		    
		 
}