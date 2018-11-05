package com.models;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Calculator {
	
	@NotEmpty
	@NotBlank
	private String lhs;
	
	@NotEmpty
	@NotBlank
	private String rhs;
	private Map<String,String> operators;
	
	private String operator;
		
	public Calculator() {
		operators = new HashMap<>();
		operators.put("+", "+");
		operators.put("-", "-");
		operators.put("*", "*");
		operators.put("/", "/");
	}
	
	
	
	public String getOperator() {
		return operator;
	}



	public void setOperator(String operator) {
		this.operator = operator;
	}



	public String getLhs() {
		return lhs;
	}

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}

	public String getRhs() {
		return rhs;
	}

	public void setRhs(String rhs) {
		this.rhs = rhs;
	}

	public Map<String, String> getOperators() {
		return operators;
	}

	public void setOperators(Map<String, String> operators) {
		this.operators = operators;
	}
	
	
	
}
