package org.aptech.t2004e.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aptech.t2004e.Dto.DishDto;
import org.aptech.t2004e.consts.PaggingEnum;
import org.aptech.t2004e.service.DishService;

//@WebServlet(name = "helloServlet", value = "/Demo")
//public class HelloServlet extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        response.sendRedirect("/index.jsp");
//    }
//
//    public void destroy() {
//    }
//}
@WebServlet(name = "dishServler", value = "/demo")
public class DishController extends HttpServlet {
	private DishService dishService = new DishService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  private String message;

  public void init() {
      message = "Hello World!";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      response.setContentType("text/html");
      DishDto criteria = new DishDto();
      // set deflaut paging
      criteria.setPage(PaggingEnum.PAGE.value);
      criteria.setSize(PaggingEnum.SIZE.value);
      
      request.setAttribute("page", dishService.gets(criteria) );
      RequestDispatcher view =  request.getRequestDispatcher("/index.jsp");   
      view.forward(request, response);
  }

  public void destroy() {
  }
}
