package com.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * 
 * @author Ali Cooper
 * This class is for checking specified fields of a 
 * binding result
 */
public class FieldChecker {
	
	public static boolean hasError(BindingResult result, String... fields) {
		
		// checks array of fields for errors
		for (FieldError field : result.getFieldErrors()) {
							
				System.out.println("FIELD: " + field.getField());
				
				for (String item : fields) {
					if (field.getField().equals(item)) {
						return true;
					}
				}
				
			
		}
		
		return false;

	}
}
