package com.demo.base;

import static io.restassured.RestAssured.given;
import static org.junit.Assume.assumeNoException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.handler.ResponseValidator;
import com.demo.util.ReusableMethods;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseClass {

	public static Response response;
	public RequestSpecification request;
	Logger logger = LogManager.getLogger(BaseClass.class);
	
	ReusableMethods reusable=new ReusableMethods();
	ResponseValidator res=new ResponseValidator();
	
	public static Map<String, String> responseBody = null;
	public static Map<Integer,String> ids=new HashMap<Integer,String>();
	


	public Response doPost(String httpMethod, String baseURL,String basePath, String jsonFile,Boolean flag) {

		try {
			String URI=baseURL+basePath;
			File jsonDataInFile = new File(System.getProperty("user.dir")+"//src//test//resources//jsonFiles//"+jsonFile);
			System.out.println("Inside POST Request");
			Response res_post = given().relaxedHTTPSValidation().log().all()
					.contentType(ContentType.JSON).body(reusable.jsonParser(jsonDataInFile, flag))
					.when().post(URI).then().extract().response();
			res_post.then().assertThat().log().all();
			response = res_post;
			res.getIDsValueFromResponse(response);
			logger.info("Record Created Successfully");

		} catch (Exception e) {
			assumeNoException("Failed in executeRequestAndGetResponse POST method", e);

		}
	
		return response;
	}

	public Response doPut(String httpMethod, String baseURL,String basePath, String jsonFile,Boolean flag) {
		
		try {
				
			File jsonDataInFile = new File(System.getProperty("user.dir")+"//src//test//resources//jsonFiles//"+jsonFile);
			System.out.println("Inside PUT Request");
			Response res_post = given().relaxedHTTPSValidation().log().all()
					.contentType(ContentType.JSON).body(reusable.jsonParser(jsonDataInFile, flag))
					.when().put(baseURL+basePath).then().extract().response();
			res_post.then().assertThat().log().all();
			response = res_post;
			res.responseSwapIDs(response);
			logger.info("Record Updated Successfully");

		} catch (Exception e) {
			assumeNoException("Failed in executeRequestAndGetResponse PUT method", e);

		}
		
		return response;
	}


	public Response doGet(String httpMethod, String baseURL,String basePath) {

		try {
			System.out.println("Inside GET Request");
			Response res_get = given()
					.relaxedHTTPSValidation().log().all().contentType(ContentType.JSON)
					.when().get(baseURL+basePath).then().extract().response();
			res_get.then().assertThat().log().all();
			response = res_get;
			res.responseSwapIDs(response);
			logger.info("Records are fetched Successfully");
		} catch (Exception e) {
			assumeNoException("Failed in executeRequestAndGetResponse GET method", e);

		}
		
		return response;
	}

	public Response doDelete(String httpMethod, String baseURL,String basePath) {

		try {
			System.out.println("Inside DELETE Request");
			Response res_del = given().relaxedHTTPSValidation().log().all()
					.contentType(ContentType.JSON)
					.when().delete(baseURL+basePath).then().extract().response();
			res_del.then().assertThat().log().all();

			response = res_del;
			res.deleteSwapResponseIDs(response);
			logger.info("Deleted Successfully");

		} catch (Exception e) {
			assumeNoException("Failed in executeRequestAndGetResponse DELETE method", e);

		}

		return response;
	}








}