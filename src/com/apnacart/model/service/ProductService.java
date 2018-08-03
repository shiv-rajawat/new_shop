package com.apnacart.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.apnacart.model.database.ProductDao;
import com.apnacart.model.database.ProductDaoImpl;
import com.apnacart.model.pojo.ProductPojo;

public class ProductService {
	
	public ArrayList<ProductPojo> getProducts() {
		
		ProductDao productDaoObj = new ProductDaoImpl();
		ArrayList<ProductPojo> productsList = new ArrayList<ProductPojo>();
		
		try {
			productDaoObj.connect();
			productsList=productDaoObj.fetchProductsFromDb();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (productsList);
		
	}
	
	public void addToCart(ProductPojo productPojo) {
		ProductDao productDaoObj = new ProductDaoImpl();
		
		try {
			productDaoObj.connect();
			productDaoObj.updateCartInDb(productPojo);
			productDaoObj.updateProductTable(productPojo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
