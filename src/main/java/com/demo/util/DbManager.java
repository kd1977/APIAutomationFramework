package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.dbtojava.PaymentDetails;

import java.lang.reflect.Field;

public class DbManager {

	
	private static Connection con = null; //SQL SERVER
	private static Connection conn = null; //MySQL
	
//MySQL
	
	public static void setMysqlDbConnection() throws SQLException, ClassNotFoundException
    {
	    try
	    {
	        //Class.forName (TestConfig.driverPath);
	        conn = DriverManager.getConnection (DbConfig.mysqlUrl, DbConfig.mysqluserName, DbConfig.mysqluserPassword);
	        if(!conn.isClosed())
				System.out.println("Successfully connected to MySQL server");
	    }
	    catch (Exception e)
	    {
	        System.err.println ("Cannot connect to database server");
	    }
    }
	
	
//SQL Server
	public static void setSqlServerDbConnection() throws SQLException, ClassNotFoundException
	{
		try
		{
		//Class.forName(DbConfig.driver);
		con = DriverManager.getConnection(DbConfig.dbConnectionUrl, DbConfig.dbUserName, DbConfig.dbPassword);
		
		if(!con.isClosed())
			System.out.println("Successfully connected to SQL server");
			
		}
		catch(Exception e)
		{
			System.err.println("Cannot connect to database server");
		}
		
		
	}
	


public static List<PaymentDetails> getMysqlQuery1(String query) throws SQLException{
	
	
	Statement St = conn.createStatement();
	ResultSet rs = St.executeQuery(query);
	List<PaymentDetails> alist = new ArrayList<PaymentDetails>();
	while(rs.next()) {
		
		PaymentDetails objPaymentDetails = new PaymentDetails();
		
		objPaymentDetails.setCustomer_id(rs.getInt(1));
		objPaymentDetails.setPayment_date(rs.getDate(2));
		objPaymentDetails.setPayment_amount(rs.getBigDecimal(3));
		objPaymentDetails.setPayment_method(rs.getString(4));
		objPaymentDetails.setTransaction_id(rs.getString(5));
		
		//SELECT customer_id, payment_date, payment_amount, payment_method, transaction_id FROM PaymentDetails;
		alist.add(objPaymentDetails);
		
	}
	return alist;
}
	
//GENERIC FUNCTION TO RETRIEVE DB RECORDS 
public static <T> List<T> getMysqlQuery2(String query, Class<T> pojoClass) throws SQLException {
    List<T> resultList = new ArrayList<>();
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        statement = conn.createStatement();
        resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            T object = pojoClass.getDeclaredConstructor().newInstance();
            Field[] fields = pojoClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = resultSet.getObject(fieldName);
                field.set(object, value);
            }

            resultList.add(object);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close the ResultSet, Statement, and any associated resources
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
    }

    return resultList;
}






	
	
}
