package com.demo.stepdefinition;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.demo.base.BaseClass;
import com.demo.handler.ResponseValidator;
import com.demo.util.Const;
import com.demo.util.PropertyReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Screen2_GetAPI_StepDef extends BaseClass {
	Logger logger = LogManager.getLogger(Screen2_GetAPI_StepDef.class);
	
	public String baseURL = PropertyReader.loadProperties().getProperty("baseURL");
	public String contentType = PropertyReader.loadProperties().getProperty("contentType");
	ResponseValidator res=new ResponseValidator();
						

	@Given("user get All records")
	public void user_get_All_records() {
		
		try {
			//response = doGet(CommonSteps.methodName, baseURL, Const.GET_USER_DATA);
			response = doGet(CommonSteps.methodName, baseURL, Const.GET_ALL_USERS);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Error Occured: Not able to fetch the record");
		}
	}

	@Given("user gets a specific record data")
	public void user_gets_a_specific_record_data() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			//response = doGet(CommonSteps.methodName, baseURL, Const.GET_USER_DATA);
			response = doGet(CommonSteps.methodName, baseURL, Const.GET_USER_DATA);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Error Occured: Not able to fetch the record");
		}
	}
	
	
	
//	2. Where the getResponseFieldValue method being used in the framework?
//	3. How to pass a query paramter to the exisitng request? If we have to pass some token/ key as part of header or query-param, how to do it?

	
}
