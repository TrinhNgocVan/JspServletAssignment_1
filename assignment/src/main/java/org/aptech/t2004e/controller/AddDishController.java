package org.aptech.t2004e.controller;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2004e.consts.DishCategoryEnum;
import org.aptech.t2004e.consts.DishStatusEnum;
import org.aptech.t2004e.dto.DishDto;
import org.aptech.t2004e.entity.Dish;
import org.aptech.t2004e.service.DishService;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5

)
@WebServlet(name = "addDishServler", value = "/dish/form")
public class AddDishController extends BaseController {
	 private static final long serialVersionUID = 1L;
	  private DishService dishService = new DishService();

	   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	      response.setContentType("text/html");	
	      DishDto dish = new DishDto();
	      if(StringUtils.isNotBlank(request.getParameter("id"))) {
	    	 dish = dishService.get(Integer.parseInt(request.getParameter("id"))) ;
	      }
	      RequestDispatcher view =  request.getRequestDispatcher("/jsp/dish-form.jsp");   
	      HashMap<String,String> categoryCodes = new HashMap<>();
	      EnumSet.allOf(DishCategoryEnum.class).stream().forEach(s -> categoryCodes.put(s.name(), s.value));
	      HashMap<String,String> status = new HashMap<>();
	      EnumSet.allOf(DishStatusEnum.class).stream().forEach(s -> status.put(s.name(), s.value));
	     
	      request.setAttribute("criteria",dish);
	      request.setAttribute("status", status);
	      request.setAttribute("categorys", categoryCodes);
	      
	      view.forward(request, response);
	  }
	   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		   request.setCharacterEncoding("UTF-8");
		   System.err.println("id : "+request.getParameter("id").trim());		  
		   DishDto dish = DishDto.builder()
				   				.id(Integer.parseInt(request.getParameter("id").trim()))
				   				.code(request.getParameter("dishCode").trim())
				   				.name(request.getParameter("dishName").trim())
				   				.categoryCode(request.getParameter("categoryCode").trim())
				   				.description(request.getParameter("description"))
				   				.price(Integer.parseInt(request.getParameter("price").trim()))
				   				.starteddate(request.getParameter("starteddate").trim())
				   				.status(request.getParameter("status").trim())
				   				.build();
		   	dishService.save(dish);
		   	addMessage(request, "Thêm mới món ăn thành công ");   
		   	response.sendRedirect("/assignment/dishs");
	   }
}
