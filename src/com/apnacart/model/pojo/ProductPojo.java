package com.apnacart.model.pojo;

public class ProductPojo {
	private int productId;
	private String productName;
	private double price;
	private int quantity;
	
	public int getProductId(){
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId=productId;
	}
	public String getProductName(){
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName=productName;
	}
	public double getPrice(){
		return this.price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}

}
