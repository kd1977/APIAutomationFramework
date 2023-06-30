package com.demo.util;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.demo.handler.ResponseValidator;

public class ReusableMethods {
	ResponseValidator res=new ResponseValidator();
	JSONObject jsonObject;
	
	public JSONObject jsonParser(File file,Boolean flag ) {
		
		JSONParser jsonParser = new JSONParser();
		 
			try {
				if(flag==true) {
				jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
				
				jsonObject.put("id", res.ids.get(res.ids.keySet().toArray()[0]));
				}else{
					jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		//System.out.println(" Request body :\n"+jsonObject);
		return jsonObject;
	}

}
