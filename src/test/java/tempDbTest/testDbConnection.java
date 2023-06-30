package tempDbTest;

import java.sql.SQLException;
import java.util.List;

import com.demo.dbtojava.CustomerDetails;
import com.demo.dbtojava.PaymentDetails;
import com.demo.util.DbManager;

public class testDbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		DbManager.setMysqlDbConnection();
		
		
		// Call the method and pass the query and POJO class at runtime
        String query = "SELECT customer_id, payment_date, payment_amount, payment_method, transaction_id FROM PaymentDetails;";
        List<PaymentDetails> paymentDetailsList = null;
		try {
			//paymentDetailsList = DbManager.getMysqlQuery1(query);
			paymentDetailsList = DbManager.getMysqlQuery2(query, PaymentDetails.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Process the retrieved List
        for (PaymentDetails paymentList : paymentDetailsList) {
         
        	System.out.println(paymentList.getCustomer_id());
        	System.out.println(paymentList.getPayment_date());
        	System.out.println(paymentList.getPayment_amount());
        	System.out.println(paymentList.getPayment_method());
        	System.out.println(paymentList.getTransaction_id());
        }
		
		
		String query2 = "SELECT customer_id, customer_name, customer_billing_address, customer_shipping_address, customer_phone, customer_email FROM CustomerDetails;";
		
				List<CustomerDetails> customerDetailsList = null;
		try {
			//paymentDetailsList = DbManager.getMysqlQuery1(query);
			customerDetailsList = DbManager.getMysqlQuery2(query2, CustomerDetails.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Process the retrieved List
        for (CustomerDetails customerList : customerDetailsList) {
         
        	System.out.println(customerList.getCustomer_id());
        	System.out.println(customerList.getCustomer_name());
        	System.out.println(customerList.getCustomer_billing_address());
        	System.out.println(customerList.getCustomer_shipping_address());
        	System.out.println(customerList.getCustomer_phone());
        	System.out.println(customerList.getCustomer_email());
        	
        }
		
	}

}
