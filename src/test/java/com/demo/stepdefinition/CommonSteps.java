package com.demo.stepdefinition;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.handler.ResponseValidator;

import io.cucumber.java.en.*;

public class CommonSteps {

	

	Logger logger = LogManager.getLogger(CommonSteps.class);
	public static String methodName;

	/**
	 * Common Step Methods used across the Project
	 */
	
	@Given("the user is on {string} screen")
	public void the_user_is_on_screen(String string) {
		logger.info("User is on " + string + "Screen");
	}


	@Given("the user request method as {string}")
	public String the_user_request_method_as(String meth_name) {
		System.out.println("Entered method is " + meth_name);
		CommonSteps.methodName = meth_name;
		return meth_name;
	}

	@Given("the user verify status code as {int}")
	public void the_user_verify_status_code(int exp_stcode) {
	//	verifyStatusCode(response, exp_stcode);
	}
	
}