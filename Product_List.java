

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="product_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product_List {
	
	@XmlElement(name="product_set")
	List<ProductSet> productSets;

	public List<ProductSet> getProductSet() {
		return productSets;
	}

	public void setProductSet(List<ProductSet> productSets) {
		this.productSets = productSets;
	}
public void add(ProductSet productSet)
{
	if(this.productSets==null)
	{
		this.productSets=new ArrayList<ProductSet>();
	}
	this.productSets.add(productSet);
}
@Override
public String toString() {
	return "Product_List [productSets=" + productSets + "]";
}
	
}
