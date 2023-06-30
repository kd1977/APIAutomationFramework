package com.demo.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyReader {
	
	private static Properties prop;

/**
 * This method is used to load the properties from config.properties file
 * @return it returns Properties prop object
 */
public static Properties loadProperties() {

	prop = new Properties();
	try {
		FileInputStream ip = new FileInputStream("src\\test\\resources\\config\\testconfig.properties");
		prop.load(ip);

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	return prop;

}


}
