


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Address {
	String street_address;
	String city;
	String postal_code;
	String country;
	public String getStreet_address() {
		return street_address;
	}
	@XmlElement
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getCity() {
		return city;
	}
	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal_code() {
		return postal_code;
	}
	@XmlElement
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCountry() {
		return country;
	}
	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "address [street_address=" + street_address + ", city=" + city + ", postal_code=" + postal_code
				+ ", country=" + country + "]";
	}

}
