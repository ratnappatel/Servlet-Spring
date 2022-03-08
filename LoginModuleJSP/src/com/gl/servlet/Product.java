package com.gl.servlet;

public class Product {
	private int id;
	private String title;
	private double price;
	private int quantity;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String title, double price,int quantity) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity=quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + "]";
	}
	

}
