package com.demo.stepdefinition;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;

import com.demo.dbtojava.PaymentDetails;
import com.demo.util.DbManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PaymentDetailsDbValidationSteps {
	
	List<PaymentDetails> paymentDetailsList;
	BigDecimal expectedPaymentAmount = new BigDecimal("100.00"); 
	BigDecimal actualPaymentAmount;
	String expectedPaymentMethod = "Credit Card";
	String actualPaymentMethod;
	
	@Given("Database setup is done")
	public void database_setup_is_done() throws ClassNotFoundException, SQLException {
	    // Below code can be put inside the CommonSteps.java file. For now, placing it here.
	    DbManager.setMysqlDbConnection();
	}

	@When("User is able to connect to the payment details table")
	public void user_is_able_to_connect_to_the_payment_details_table() throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		String query = "SELECT customer_id, "
				+ "payment_date, "
				+ "payment_amount, "
				+ "payment_method, "
				+ "transaction_id "
				+ "FROM PaymentDetails WHERE transaction_id='ABC123';";
		paymentDetailsList = DbManager.getMysqlQuery2(query, PaymentDetails.class);
	}

	@Then("User is able to retrieve payment details records")
	public void user_is_able_to_retrieve_payment_details_records() {
	    // Write code here that turns the phrase above into concrete actions
		for (PaymentDetails paymentList : paymentDetailsList) {
	         
        	System.out.println(paymentList.getCustomer_id());
        	System.out.println(paymentList.getPayment_date());
        	System.out.println(paymentList.getPayment_amount());
        	System.out.println(paymentList.getPayment_method());
        	System.out.println(paymentList.getTransaction_id());
        	
        	actualPaymentAmount = paymentList.getPayment_amount();
        	actualPaymentMethod = paymentList.getPayment_method();
        	
        }
	}
	
	@Then("User is able to verify the payment details records")
	public void user_is_able_to_verify_the_payment_details_records() {
	    Assert.assertEquals(expectedPaymentMethod, actualPaymentMethod);
	    Assert.assertEquals(expectedPaymentAmount, actualPaymentAmount);
	}

}
