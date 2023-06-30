package com.demo.stepdefinition;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import com.demo.dbtojava.CustomerDetails;
import com.demo.util.DbManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CustomerDetailsDbValidationSteps {
	
	List<CustomerDetails> customerDetailsList;
	String customerName;
	String customerBillingAddress;
	
	@When("User is able to connect to the customer details table")
	public void user_is_able_to_connect_to_the_customer_details_table() throws SQLException {
		String sqlQry = "SELECT "
				+ "customer_id, "
				+ "customer_name, "
				+ "customer_billing_address, "
				+ "customer_shipping_address, "
				+ "customer_phone, "
				+ "customer_email "
				+ "FROM CustomerDetails WHERE customer_id=1;";
		customerDetailsList = DbManager.getMysqlQuery2(sqlQry, CustomerDetails.class);
	}

	@Then("User is able to retrieve customer details records")
	public void user_is_able_to_retrieve_customer_details_records() {
		 // Process the retrieved List
        for (CustomerDetails customerList : customerDetailsList) {
         
        	System.out.println(customerList.getCustomer_id());
        	System.out.println(customerList.getCustomer_name());
        	System.out.println(customerList.getCustomer_billing_address());
        	System.out.println(customerList.getCustomer_shipping_address());
        	System.out.println(customerList.getCustomer_phone());
        	System.out.println(customerList.getCustomer_email());
        	customerName = customerList.getCustomer_name();
        	customerBillingAddress = customerList.getCustomer_billing_address();
        	
        }
	}
	
	@Then("User is able to verify the customer details records")
	public void user_is_able_to_verify_the_customer_details_records(DataTable dataTable) {
		
	   Assert.assertEquals(dataTable.cell(1, 0), customerName);
	   Assert.assertEquals(dataTable.cell(1, 1), customerBillingAddress);
	}


}
