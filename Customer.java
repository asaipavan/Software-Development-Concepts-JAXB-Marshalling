

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	@XmlElement
	String customer_name;
	@XmlElement
	Address address;
	@XmlElement
	int num_orders;
	@XmlElement
	String order_value;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getNum_orders() {
		return num_orders;
	}
	public void setNum_orders(int num_orders) {
		this.num_orders = num_orders;
	}
	public String getOrder_value() {
		return order_value;
	}
	public void setOrder_value(String order_value) {
		this.order_value = order_value;
	}
	@Override
	public String toString() {
		return "Customer [customer_name=" + customer_name + ", address=" + address + ", num_orders=" + num_orders
				+ ", order_value=" + order_value + "]";
	}

}

