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

public class Screen2_PutAPI_StepDef extends BaseClass {
	Logger logger = LogManager.getLogger(Screen2_PutAPI_StepDef.class);
	
	public String baseURL = PropertyReader.loadProperties().getProperty("baseURL");
	public String contentType = PropertyReader.loadProperties().getProperty("contentType");
	ResponseValidator res=new ResponseValidator();
						

	

	@Given("user update the record")
	public void user_updates_a_record(DataTable requestData) {
		try {
			List<Map<String, String>> listData = requestData.asMaps(String.class, String.class);
			
			response = doPut(CommonSteps.methodName, baseURL, Const.UPDATE_USER,
					listData.get(0).get("JsonFileName"),false);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Error Occured: Not able to update record");
		}
	}
	
	
}
