package org.aptech.t2004e.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.aptech.t2004e.config.AppProperties;

public class BaseController  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AppProperties appProperties = new AppProperties() ;
	public static final String ERRORS_SESSION = "errors";
	public static final String MESSAGES_SESSION = "messages";
	    
	List<String> errorList = null;
	List<String> messageList = null;
	
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	    public void addError(HttpServletRequest request, String error) {
	    	List errors = (List) request.getSession().getAttribute(ERRORS_SESSION);
	    	if (errors == null) {
	    		errors = new ArrayList<>();
	    	}
	        errors.add(error);
	        request.getSession().setAttribute(ERRORS_SESSION, errors);
	    }

	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    public void addMessage(HttpServletRequest request, String msg) {
	    	List messages = (List) request.getSession().getAttribute(MESSAGES_SESSION);
	    	if (messages == null) {
	    		messages = new ArrayList<>();
	    	}
	    	messages.add(msg);
	    	request.getSession().setAttribute(MESSAGES_SESSION, messages);
	    }


}
