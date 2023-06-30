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

public class Screen1_E2EAPI_StepDef extends BaseClass {
	Logger logger = LogManager.getLogger(Screen1_E2EAPI_StepDef.class);
	
	public String baseURL = PropertyReader.loadProperties().getProperty("baseURL");
	public String contentType = PropertyReader.loadProperties().getProperty("contentType");
	ResponseValidator res=new ResponseValidator();
						

	@Given("the user creates a new record and store the new generated id")
	public void the_user_creates_a_record(DataTable requestData) {
		try {
			List<Map<String, String>> listData = requestData.asMaps(String.class, String.class);
			response = doPost(CommonSteps.methodName, baseURL, Const.E2EAPI,
					listData.get(0).get("JsonFileName"),false);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Error Occured: Not able to create a record");
		}
	
	}
	
	@Given("the user updates a record for new generated id")
	public void the_user_updates_a_record(DataTable requestData) {
		try {
			List<Map<String, String>> listData = requestData.asMaps(String.class, String.class);
			
			response = doPut(CommonSteps.methodName, baseURL, Const.E2EAPI+res.ids.get(res.ids.keySet().toArray()[0]),
					listData.get(0).get("JsonFileName"),true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Error Occured: Not able to update record");
		}
	}
	@Given("the user get the record for new generated id")
	public void the_user_get_All_records() {
		
		try {
			response = doGet(CommonSteps.methodName, baseURL, Const.E2EAPI+res.ids.get(res.ids.keySet().toArray()[0]));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Error Occured: Not able to fetch the record");
		}
	}

	@Given("the user delete a record for new generated id")
	public void the_user_delete_a_record() {
		try {
			response = doDelete(CommonSteps.methodName, baseURL, Const.E2EAPI+res.ids.get(res.ids.keySet().toArray()[0]));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Error Occured: Not able to delete the record");
		}
	}
	

	
}
