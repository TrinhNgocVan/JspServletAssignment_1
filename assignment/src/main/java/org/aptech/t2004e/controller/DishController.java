package org.aptech.t2004e.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aptech.t2004e.dto.DishDto;
import org.aptech.t2004e.service.DishService;

@WebServlet(name = "dishServler", value = "/dishs")
public class DishController extends BaseController {
  private static final long serialVersionUID = 1L;
  private DishService dishService = new DishService();

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      response.setContentType("text/html");
      DishDto criteria = new DishDto();
      criteria.setPage(appProperties.getDefaultPage());
      criteria.setSize(appProperties.getDefaultPageSize()); 
      System.err.println(dishService.gets(criteria));
      request.setAttribute("page", dishService.gets(criteria) ); 
      RequestDispatcher view =  request.getRequestDispatcher("/index.jsp");   
      view.forward(request, response);
  }
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	   response.setContentType("text/html");
	   DishDto criteria  = new DishDto();
	   criteria.setPage(Integer.parseInt(request.getParameter("page")) );
	   criteria.setSize(Integer.parseInt(request.getParameter("size")));
	   request.setAttribute("page", dishService.gets(criteria) );
	   RequestDispatcher view =  request.getRequestDispatcher("/index.jsp");   
	   view.forward(request, response);
   }
   
}
