package com.exceptions;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "com.controllers")
public class GlobalExceptionHandler {
	
	  @ExceptionHandler(DAOException.class)
	  public ModelAndView dataAccessObjectError(final DAOException e) {
		  
		  ModelAndView mv = new ModelAndView("errorPage");
		  mv.addObject("error", e.getStackTrace());
		  mv.addObject("errorCode", Integer.valueOf(500));
		  
	    return mv;
	  }
}
