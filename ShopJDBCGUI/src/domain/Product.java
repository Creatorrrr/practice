package domain;

import constants.Constants;

public class Product {
	private String productId;
	private String productName;
	private String category;
	private String information;
	
	public Product(){}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "PID:" + productId + ", 상품명:" + productName + ", 종류:" + category
				+ ", 정보:" + information;
	}
	
	public String[] getArray() {
		String[] info = new String[Constants.ORDER_COLUMN];
		info[0] = this.productId;
		info[1] = this.productName;
		info[2] = this.category;
		info[3] = this.information;
		
		return info;
	}
}
