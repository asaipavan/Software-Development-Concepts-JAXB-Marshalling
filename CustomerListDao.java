
import java.sql.*;
public class CustomerListDao {
	//JDBC connection to pull the customer list details from Database 
	public Customer_List customerListmethod(String start_date,String end_date) throws ClassNotFoundException,SQLException
	{
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet= null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://db.cs.dal.ca:3306?serverTimezone=UTC", "akuralapu", "B00844989");
		statement = connect.createStatement();
		statement.execute("use csci3901;");
		resultSet=statement.executeQuery("select customers.customerName,customers.addressLine1,customers.city,customers.postalCode,customers.country,count(orders.orderNumber),sum(orderdetails.quantityOrdered*orderdetails.priceEach) from customers "+ 
				"JOIN orders on (customers.customerNumber=orders.customerNumber) "+ 
				"JOIN orderdetails on (orders.orderNumber=orderdetails.orderNumber) "+ 
				"where orders.orderDate>='"+start_date+"' and orders.orderDate<='"+end_date+"' and orders.status!='cancelled' group by customers.customerName");
		
		Customer_List coList=new Customer_List();
		while (resultSet.next()) 
		{
			Customer customer=new Customer();
			Address address=new Address();
			customer.setCustomer_name(resultSet.getString("customers.customerName"));
			address.setStreet_address(resultSet.getString("customers.addressLine1"));
			address.setCity(resultSet.getString("customers.city"));
			address.setPostal_code(resultSet.getString("customers.postalCode"));
			address.setCountry(resultSet.getString("customers.country"));
			customer.setNum_orders(Integer.parseInt(resultSet.getString(6)));
			customer.setOrder_value(resultSet.getString(7));
			customer.setAddress(address);
			coList.add(customer);
			
		}
		resultSet.close();

		statement.close();
		connect.close();
return coList;
}
}
