

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMethod {
public static void main(String args[]) throws ClassNotFoundException, SQLException
{
		String start_date,end_date,file;
		//Regular expression for YYYY-MM-DD format
		String regexDate = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
		String regexFileName = "^[a-z A-Z]*[0-9]*[-_]*{1}";
		boolean flag;
		Scanner scanner = new Scanner(System.in);
		do
		{
			System.out.println("start date");
			start_date=scanner.nextLine();
			
			flag = Pattern.compile(regexDate).matcher(start_date).matches();
		}while(!flag);

		do
		{
			System.out.println("end date");
			end_date=scanner.nextLine();  
			flag = Pattern.compile(regexDate).matcher(end_date).matches();
		}while(!flag);
		
	
	do
	{
		System.out.println("file");
		file=scanner.nextLine();
		flag = Pattern.compile(regexFileName).matcher(file).matches();
	}while(!flag);
	JAXB jaxb=new JAXB();
	jaxb.JAXBMethod(start_date, end_date, file);
	
}
}
