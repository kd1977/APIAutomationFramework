package com.demo.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeNoException;

import java.util.HashMap;
import java.util.Map;

import com.demo.base.BaseClass;

import io.restassured.response.Response;

public class ResponseValidator {


	public static Map<Integer,String> ids=new HashMap<Integer,String>();

	/**
	 * Method used for Verification of Status Code
	 */
	public void verifyStatusCode(Response response, int statusExpected) {
		try {

			assertEquals("Response retrieved is null", response != null, true);
			assertEquals("Response status code is not matching", statusExpected, response.getStatusCode());
			System.out.println("Status code is displaying as expected");
		} catch (Exception e) {
			assumeNoException("Failed in verifyStatusCode method", e);
		}
	}


	public  void getIDsValueFromResponse(Response response) {
		String id = response.body().jsonPath().get("id");
		System.out.println("id:-"+id);
		ids.put(ids.size(), id);
		System.out.println("map id:-"+ids);
	}

	public void responseSwapIDs(Response response) {
		if (ids.size()>0) {
			ids.remove(ids.keySet().toArray()[0]);
			System.out.println("After removed id:-"+ids);
			String id = response.body().jsonPath().get("id");
			System.out.println("id:-"+id);
			Object lastIndex = 0;
			if(ids.size()==0)
				System.out.println("Map is empty");
			else
				lastIndex = ids.keySet().toArray()[ids.size()-1];
			ids.put(Integer.parseInt(lastIndex.toString())+1, id);
			System.out.println("map id:-"+ids);
		}
	}
		
		public void deleteSwapResponseIDs(Response response) {
			if (ids.size()>0) {
				ids.remove(ids.keySet().toArray()[0]);
				System.out.println("map id:-"+ids);
			}}
		


	
	public  String getResponseFieldValue(Response response,String fieldName) {
		
		String fieldValue=response.body().jsonPath().get(fieldName);
		System.out.println(fieldName+" value is:-"+fieldValue);
		return fieldValue;
		
	}


}
