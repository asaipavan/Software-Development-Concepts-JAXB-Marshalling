


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="customer_list")
public class Customer_List {
List<Customer> customers;

public List<Customer> getCustomers() {
	return customers;
}
@XmlElement(name="customer")
public void setCustomers(List<Customer> customers) {
	this.customers = customers;
}
public void add(Customer customer)
{
	if(this.customers==null)
	{
		this.customers=new ArrayList<Customer>();
	}
	this.customers.add(customer);
}
@Override
public String toString() {
	return "Customer_List [customers=" + customers + "]";
}

}
