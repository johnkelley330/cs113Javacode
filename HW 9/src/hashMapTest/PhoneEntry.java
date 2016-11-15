package hashMapTest;
/**
 * This class stores the data fields for phone entry.
 * @author scout
 *
 */
public class PhoneEntry {
	private String name;
	private String phoneNumber;
	private String city;
	private String zip;

	public PhoneEntry(String name, String phoneNumber, String city, String zip) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.zip = zip;
	}

	public String toString() {
		return "[" + name + ", " + phoneNumber + ", " + city + ", " + zip + "]";
	}

	public boolean equals(Object o) {
		if (o instanceof PhoneEntry) {
			return name == ((PhoneEntry) o).getName() && city == ((PhoneEntry) o).getcity()
					&& zip == ((PhoneEntry) o).getZip() && phoneNumber == ((PhoneEntry) o).getPhoneNumber();
		}
		return false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getcity() {
		return city;
	}

	public String getZip() {
		return zip;
	}
}
