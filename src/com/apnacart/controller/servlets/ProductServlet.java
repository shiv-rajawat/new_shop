package com.apnacart.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apnacart.model.pojo.ProductPojo;

import com.apnacart.model.service.ProductService;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		ProductService productServiceObj = new ProductService();
		ArrayList<ProductPojo> productsList = new ArrayList<ProductPojo>();
		
		productsList = productServiceObj.getProducts();
		request.setAttribute("productsList", productsList);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
		
		if(request.getParameter("addToCart") != null) {
			
			String quantityString = request.getParameter("quantity");			
			String id = request.getParameter("id");			
			String priceString = request.getParameter("price");
			Double price = Double.valueOf(priceString);
			
			int quantity = Integer.parseInt(quantityString);
			int productId = Integer.parseInt(id);
			
			
			ProductPojo productPojo = new ProductPojo();
	      	productPojo.setProductId(productId);
	      	productPojo.setQuantity(quantity);
	      	productPojo.setProductName(request.getParameter("name"));
	      	productPojo.setPrice(price);
			
	      	
			productServiceObj.addToCart(productPojo);
			return;
						
		}
	}

}
