package com.demo.dbtojava;

public class CustomerDetails {
	
	/*
	 * 
	 * use dbdemo;
		CREATE TABLE CustomerDetails (
		  customer_id INT PRIMARY KEY AUTO_INCREMENT,
		  customer_name VARCHAR(50) NOT NULL,
		  customer_billing_address VARCHAR(50) NOT NULL,
		  customer_shipping_address VARCHAR(50) NOT NULL,
          customer_phone VARCHAR(50) NOT NULL,
          customer_email VARCHAR(50) NOT NULL
          )
	 */
	
	//customer_name, customer_billing_address, customer_shipping_address, customer_phone, customer_email
	private String customer_name = "";
	private String customer_billing_address = "";
	private String customer_shipping_address = "";
	private String customer_phone = "";
	private String customer_email = "";
	private int customer_id = 0;
	
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_billing_address() {
		return customer_billing_address;
	}
	public void setCustomer_billing_address(String customer_billing_address) {
		this.customer_billing_address = customer_billing_address;
	}
	public String getCustomer_shipping_address() {
		return customer_shipping_address;
	}
	public void setCustomer_shipping_address(String customer_shipping_address) {
		this.customer_shipping_address = customer_shipping_address;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	
}
