
package com.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotNull
	private int id;
    
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "First Name Must be between 3 and 10 characters")    
	@NotNull
	private String firstName;
	
	
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Last Name Must be between 3 and 10 characters")
	@NotNull
	private String lastName;
	
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Username Must be between 3 and 10 characters")
	@NotNull
	private String username;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Email(message = "Must be a valid email")
	private String email;
	
	@Size(min = 3, max = 10, message = "Password Must be between 3 and 10 characters")	
	@NotNull
	private String password;
	
	public User() {
		this(-1,"","","","","");
	}
	
	public User(int id, String firstName, String lastName, String username, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	
	
	
}
