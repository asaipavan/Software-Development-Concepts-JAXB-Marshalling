

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffListDao {
	
	//JDBC connection to pull the stafflist details from Database
	
	
public Staff_List staffListmethod(String start_date,String end_date) throws ClassNotFoundException, SQLException
{
	Connection connect = null;
	Statement statement = null;
	ResultSet resultSet= null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	connect = DriverManager.getConnection("jdbc:mysql://db.cs.dal.ca:3306?serverTimezone=UTC", "akuralapu", "B00844989");
	statement = connect.createStatement();
	statement.execute("use csci3901;");
	resultSet=statement.executeQuery("select employees.firstName,employees.lastName,offices.city,count(distinct customers.customerNumber),sum(orderdetails.quantityOrdered*orderdetails.priceEach) from employees " + 
			"join offices on (employees.officeCode=offices.officeCode) " + 
			"join customers on (employees.employeeNumber=customers.salesRepEmployeeNumber) " + 
			"join orders on (customers.customerNumber=orders.customerNumber) " + 
			"join orderdetails on (orders.orderNumber=orderdetails.orderNumber) where orders.orderDate>='"+start_date+"' and orders.orderDate<='"+end_date+"' and orders.status!='cancelled' group by employees.employeeNumber");
	
	Staff_List staff_List=new Staff_List();
	while(resultSet.next())
	{
		//creating a new employee object to set staffList details
		Employee employee=new Employee();
		employee.setFirst_name(resultSet.getString("employees.firstName"));
		employee.setLast_name(resultSet.getString("employees.lastName"));
		employee.setOffice_city(resultSet.getString("offices.city"));
		employee.setActive_customers(resultSet.getString(3));
		employee.setTotal_sales(resultSet.getString(4));
		staff_List.add(employee);
		
	}
	
	return staff_List;
	
}
}
