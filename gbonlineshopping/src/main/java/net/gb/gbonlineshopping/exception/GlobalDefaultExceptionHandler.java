package net.gb.gbonlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		mv.addObject("errorDescription", "The page you are looking for is not available now!");
		mv.addObject("Title", "404 Error Page");
		
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not available!");
		mv.addObject("errorDescription", "The product you are looking for is not available right now!");
		mv.addObject("Title", "Product Unavailable");
		
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact your Administrator!");
		
		/*
		 * 
		 * Only for Debugging
		 * */
		//StringWriter sw = new StringWriter();
		//PrintWriter pw = new PrintWriter(sw);
		
		//ex.printStackTrace(pw);
		//mv.addObject("errorDescription", sw.toString());
		
		mv.addObject("errorDescription", ex.toString());
		mv.addObject("Title", "Error");
		
		return mv;
		
	}

}
