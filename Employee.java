

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	@XmlElement(name="first_name")
	String first_name;
	@XmlElement(name="last_name")
	String last_name;
	@XmlElement(name="office_city")
	String office_city;
	@XmlElement(name="active_customers")
	String active_customers;
	@XmlElement(name="total_sales")
	String total_sales;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getOffice_city() {
		return office_city;
	}
	public void setOffice_city(String office_city) {
		this.office_city = office_city;
	}
	public String getActive_customers() {
		return active_customers;
	}
	public void setActive_customers(String active_customers) {
		this.active_customers = active_customers;
	}
	public String getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(String total_sales) {
		this.total_sales = total_sales;
	}
	@Override
	public String toString() {
		return "Employee [first_name=" + first_name + ", last_name=" + last_name + ", office_city=" + office_city
				+ ", active_customers=" + active_customers + ", total_sales=" + total_sales + "]";
	}


}
