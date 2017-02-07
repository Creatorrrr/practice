package domain;

import constants.Constants;

public class Customer {
	private String id;
	private String passwd;
	private String name;
	private int age;
	private String address;

	public Customer() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", 이름: " + name + ", 나이: " + age + ", 주소: " + address;
	}
	
	public String[] getArray() {
		String[] info = new String[Constants.CUSTOMER_COLUMN];
		info[0] = this.id;
		info[1] = this.passwd;
		info[2] = this.name;
		info[3] = this.age + "";
		info[4] = this.address;
		
		return info;
	}
}
