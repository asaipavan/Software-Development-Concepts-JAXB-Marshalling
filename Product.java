

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	@XmlElement(name="product_name")
String product_name;
	@XmlElement(name="product_vendor")
String product_vendor;
	@XmlElement(name="units_sold")
String units_sold;
	@XmlElement(name="total_sales")
String total_sales;
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_vendor() {
	return product_vendor;
}
public void setProduct_vendor(String product_vendor) {
	this.product_vendor = product_vendor;
}
public String getUnits_sold() {
	return units_sold;
}
public void setUnits_sold(String units_sold) {
	this.units_sold = units_sold;
}
public String getTotal_sales() {
	return total_sales;
}

public void setTotal_sales(String total_sales) {
	this.total_sales = total_sales;
}
@Override
public String toString() {
	return "Product [product_name=" + product_name + ", product_vendor=" + product_vendor + ", units_sold=" + units_sold
			+ ", total_sales=" + total_sales + "]";
}

}
