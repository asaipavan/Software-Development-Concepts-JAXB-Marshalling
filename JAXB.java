

import java.io.File;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXB {


//Method to convert from JavaObject to XML with the help of JAXB

	public void JAXBMethod(String start_date,String end_date,String fileName) throws ClassNotFoundException, SQLException
	{
		try {

			File file = new File(fileName+".xml");

			CustomerListDao customerListDao=new CustomerListDao();
			StaffListDao staffListDao=new StaffListDao();
			ProductListDao productListDao=new ProductListDao();
			Customer_List coList=new Customer_List();
			Product_List product_List=new Product_List();
			Staff_List staff_List=new Staff_List();
			YearEndSummary yearEndSummary=new YearEndSummary();
			Year year=new Year();
			year.setStart_date(start_date); 
			year.setEnd_date(end_date);
			//Calls the customerList Dao and pulls the customer list details
			coList=customerListDao.customerListmethod(start_date,end_date);
            //Calls the StaffList Dao and pulls the stafflist details
			staff_List=staffListDao.staffListmethod(start_date,end_date);
			//calls the productList Dao and pulls the productlist details
			product_List=productListDao.productListmethod(start_date,end_date);
			yearEndSummary.setYear(year);
			yearEndSummary.setCustomer_List(coList);
			yearEndSummary.setStaff_List(staff_List);
			yearEndSummary.setProduct_List(product_List);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(YearEndSummary.class);
			//Marshaller converts Java Object to XML
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(yearEndSummary, file);

		} catch (JAXBException e) {
			System.out.println("Exception with JAXB");
		}

	}
}


