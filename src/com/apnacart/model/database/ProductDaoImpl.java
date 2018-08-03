package com.apnacart.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.apnacart.model.pojo.ProductPojo;

public class ProductDaoImpl implements ProductDao {

	Connection con;
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingApplication", "root", "smrajawat");		
	}
	
	public ArrayList<ProductPojo> fetchProductsFromDb() throws SQLException, ClassNotFoundException {
		String query="select * from ProductDetails;";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
				
		ArrayList<ProductPojo> productsList = new ArrayList<ProductPojo>();
		while(rs.next()) {
			ProductPojo productPojo = new ProductPojo();
			productPojo.setProductId(rs.getInt(1));
			productPojo.setProductName(rs.getString(2));
			productPojo.setPrice(rs.getDouble(3));
			productPojo.setQuantity(rs.getInt(4));
			
			productsList.add(productPojo);			
		}	
		return(productsList);
	}

	public void updateCartInDb(ProductPojo productPojo) throws SQLException, ClassNotFoundException  {
		String insertStatement = "insert into cart (userId, productId, productName, quantity, totalAmount) values (?,?,?,?,?);";
		PreparedStatement preparedStatement = con.prepareStatement(insertStatement);
		preparedStatement.setInt(1,UserDaoImpl.userObj.getId());
		preparedStatement.setInt(2, productPojo.getProductId());
		preparedStatement.setString(3, productPojo.getProductName());
		preparedStatement.setInt(4, productPojo.getQuantity());
		preparedStatement.setDouble(5, ( productPojo.getPrice())*(productPojo.getQuantity()));
		
		preparedStatement.executeUpdate();
				
		
	}

	@Override
	public void updateProductTable(ProductPojo productPojo) throws SQLException {
					
		String retrieveQuery = "Select quantity from productdetails where productId = ?;";
		PreparedStatement preparedStatement = con.prepareStatement(retrieveQuery);
		preparedStatement.setInt(1,productPojo.getProductId());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
		
			String updateQuery = "Update productdetails set quantity = ? where productId = ?;";
			PreparedStatement prepareStatement = con.prepareStatement(updateQuery);
			prepareStatement.setInt(1,(resultSet.getInt(1)-productPojo.getQuantity()));
			prepareStatement.setInt(2,productPojo.getProductId());
			prepareStatement.executeUpdate();
		}
		con.close();
	}
}
		


