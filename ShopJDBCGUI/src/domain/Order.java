package domain;

import java.sql.Date;

import constants.Constants;

public class Order {
	private String id;
	private String productId;
	private Date orderDate;
	private int quantity;
	
	public Order(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Customer ID:" + id + ", Product ID:" + productId + ", 주문일: " + orderDate + ", 주문수량:" + quantity;
	}
	
	public String[] getArray() {
		String[] info = new String[Constants.PRODUCT_COLUMN];
		info[0] = this.id;
		info[1] = this.productId;
		info[2] = this.orderDate + "";
		info[3] = this.quantity + "";
		
		return info;
	}
}
