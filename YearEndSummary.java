

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="year_end_summary")
@XmlAccessorType(XmlAccessType.FIELD)
public class YearEndSummary {
	@XmlElement(name="year")
	Year year;
	@XmlElement(name="customer_list")
	Customer_List customer_List;
	@XmlElement(name="product_list")
	Product_List product_List;
	@XmlElement(name="staff_list")
	Staff_List staff_List;
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public Customer_List getCustomer_List() {
		return customer_List;
	}

	public void setCustomer_List(Customer_List customer_List) {
		this.customer_List = customer_List;
	}



	public Product_List getProduct_List() {
		return product_List;
	}
	public void setProduct_List(Product_List product_List) {
		this.product_List = product_List;
	}
	public Staff_List getStaff_List() {
		return staff_List;
	}
	public void setStaff_List(Staff_List staff_List) {
		this.staff_List = staff_List;
	}
	@Override
	public String toString() {
		return "YearEndSummary [year=" + year + ", customer_List=" + customer_List + ", product_List=" + product_List
				+ ", staff_List=" + staff_List + "]";
	}




}
