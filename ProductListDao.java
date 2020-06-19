

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProductListDao {
	public Product_List productListmethod(String start_date,String end_date) throws ClassNotFoundException,SQLException
	{
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet= null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://db.cs.dal.ca:3306?serverTimezone=UTC", "akuralapu", "B00844989");
		statement = connect.createStatement();
		statement.execute("use csci3901;");
		resultSet=statement.executeQuery("select products.productName,products.productLine,products.productVendor,orderdetails.quantityOrdered,orderdetails.quantityOrdered*orderdetails.priceEach from products " + 
				"join orderdetails on (products.productCode=orderdetails.productCode) " + 
				"join orders on (orderdetails.orderNumber=orders.orderNumber) where orders.orderDate>='"+start_date+"' and orders.orderDate<='"+end_date+"' and orders.status!='cancelled' " + 
				"group by productName;");
		
		
		
		Product_List product_List=new Product_List();
		while (resultSet.next()) 
		{
			
			ProductSet p=checkElement(resultSet.getString("products.productLine"), product_List);
			if(p==null)
			{
		       ProductSet productSet=new ProductSet();
		       productSet.setProduct_line_number(resultSet.getString("products.productLine"));
		       Product product=new Product();
		       product.setProduct_name(resultSet.getString("products.productName"));
		       product.setProduct_vendor(resultSet.getString("products.productVendor"));
		       product.setTotal_sales(resultSet.getString(4));
				product.setUnits_sold(resultSet.getString(3));
				productSet.add(product);
				product_List.add(productSet);
			}
			else
			{
			Product product=new Product();
			product.setProduct_name(resultSet.getString("products.productName"));
			product.setProduct_vendor(resultSet.getString("products.productVendor"));
			product.setTotal_sales(resultSet.getString(4));
			product.setUnits_sold(resultSet.getString(3));
			p.add(product);
			
		}
			
			
			
		}
		resultSet.close();

		statement.close();
		connect.close();
return product_List;
}
	//method to checkElement whether product line is
	private static  ProductSet checkElement(String productLine,Product_List product_List)
	{
		try
		{
	 List<ProductSet> proList=product_List.getProductSet();
	 if(!proList.isEmpty())
	 {
		 for(ProductSet productSet:proList)
	  {
		  if(productSet.getProduct_line_number().equals(productLine))
		  {
			  return productSet;
		  }
		  
	  }
   		
	 }
		}
		catch(Exception e)
		{
		return null;
		}
		
		
		return null;
	}

}
