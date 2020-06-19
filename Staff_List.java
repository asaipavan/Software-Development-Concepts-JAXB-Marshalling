

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="staff_list")
public class Staff_List {

	List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}
@XmlElement(name="employee")
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
public void add(Employee employee)
{
	if(this.employees==null)
	{
		this.employees=new ArrayList<Employee>();
	}
	this.employees.add(employee);
}
@Override
public String toString() {
	return "Staff_List [employees=" + employees + "]";
}
	

}
