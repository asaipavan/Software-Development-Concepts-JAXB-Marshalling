


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="year")
public class Year {
String start_date;
String end_date;
public String getStart_date() {
	return start_date;
}
@XmlElement(name="start_date")
public void setStart_date(String start_date) {
	this.start_date = start_date;
}
public String getEnd_date() {
	return end_date;
}
@XmlElement(name="end_date")
public void setEnd_date(String end_date) {
	this.end_date = end_date;
}
@Override
public String toString() {
	return "Year [start_date=" + start_date + ", end_date=" + end_date + "]";
}


}
