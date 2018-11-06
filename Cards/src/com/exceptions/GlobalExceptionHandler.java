package com.exceptions;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "com.controllers")
public class GlobalExceptionHandler {
	
	  @ExceptionHandler(DAOException.class)
	  public ModelAndView dataAccessObjectError(final DAOException e) {
		  
		  ModelAndView mv = new ModelAndView("errorPage");
		  mv.addObject("error", e.getMessage());
		  mv.addObject("errorCode", Integer.valueOf(500));
		  
	    return mv;
	  }
	  
	  @ExceptionHandler(NullPointerException.class)
	  public ModelAndView nullPtrError(final DAOException e) {
		  
		  ModelAndView mv = new ModelAndView("errorPage");
		  mv.addObject("error", e.getMessage());
		  mv.addObject("errorCode", Integer.valueOf(500));
		  
	    return mv;
	  }
	
}
