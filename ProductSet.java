

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product_set")
public class ProductSet {
String product_line_number;
List<Product> products;

public List<Product> getProducts() {
	return products;
}
@XmlElement
public void setProducts(List<Product> products) {
	this.products = products;
}
public String getProduct_line_number() {
	return product_line_number;
}
@XmlElement
public void setProduct_line_number(String product_line_number) {
	this.product_line_number = product_line_number;
}
public void add(Product product)
{
	if(this.products==null)
	{
		this.products=new ArrayList<Product>();
	}
	this.products.add(product);
}
@Override
public String toString() {
	return "ProductSet [product_line_number=" + product_line_number + ", products=" + products + "]";
}



}
