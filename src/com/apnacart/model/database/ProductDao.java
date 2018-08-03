package com.apnacart.model.database;

import java.sql.SQLException;
import java.util.ArrayList;

import com.apnacart.model.pojo.ProductPojo;

public interface ProductDao {
	public void connect() throws ClassNotFoundException, SQLException;
	public ArrayList<ProductPojo> fetchProductsFromDb() throws SQLException, ClassNotFoundException;
	public void updateCartInDb(ProductPojo productPojo) throws SQLException, ClassNotFoundException;
	public void updateProductTable(ProductPojo productPojo) throws SQLException;

}
