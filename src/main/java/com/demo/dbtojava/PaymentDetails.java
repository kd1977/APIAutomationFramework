package com.demo.dbtojava;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentDetails {

	/*
	 * use dbdemo;
		CREATE TABLE PaymentDetails (
		  id INT PRIMARY KEY AUTO_INCREMENT,
		  customer_id INT NOT NULL,
		  payment_date DATE NOT NULL,
		  payment_amount DECIMAL(10, 2) NOT NULL,
		  payment_method VARCHAR(50) NOT NULL,
		  transaction_id VARCHAR(50) NOT NULL
  
		);
	 * 
	 */
	private Date payment_date = null;
	private BigDecimal payment_amount = null;
	private String payment_method = "";
	private String transaction_id = "";
	private int customer_id = 0;
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public BigDecimal getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(BigDecimal payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	
	
}
