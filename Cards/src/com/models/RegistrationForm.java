package com.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {


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
	@NotNull
	@Email(message = "Must be a valid email")
	private String email;

	@Valid
	User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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
	
	
	
	
}
