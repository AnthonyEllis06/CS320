
/*
 * Author: 		Anthony Ellis
 * Date:		01/24/2023
 * Description:	Contact object class
 * 
 */
public class Contact {
	//Contact variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	//Constructor: object can only be created with valid non-null variables.
	//ID must be a maximum string length of 10.
	//First name must be a maximum string length 10.
	//Last name must be a maximum string length of 10.
	//Number must be an EXACT string length of 10. 
	//Address must me a maximum string length of 30.
	Contact(String id, String fName, String lName, String num,String addr){
		setContactID(id);
		setFirstName(fName);
		setLastName(lName);
		setNumber(num);
		setAddress(addr);
	}
	//Sets the contact ID, is private to only allow it to be called once during the constructor.
	private void setContactID(String contactID) {
		if(contactID == null || contactID.length() > 10)//verifies string correct length and not null
			throw new IllegalArgumentException("Invalid ID");//Throws exception for invalid id.
		this.contactID = contactID;
	}
	//Returns contact ID.
	public String getContactID() {
		return contactID;
	}
	//Returns First Name
	public String getFirstName() {
		return firstName;
	}
	//Sets or updates First Name
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10)//Verifies that the name is valid and if not throws an exception
			throw new IllegalArgumentException("Invalid First Name");
		this.firstName = firstName;
	}
	//Returns Last Name
	public String getLastName() {
		return lastName;
	}
	//Sets or updates Last Name
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10)//Validates and sets the input last name or throws exception
			throw new IllegalArgumentException("Invalid Last Name");
		this.lastName = lastName;
	}
	//Returns Contact Number
	public String getNumber() {
		return Number;
	}
	//Sets or Updates the contact number
	public void setNumber(String number) {
		if(number.length() != 10 || number == null)//Validates that the number is the correct number of characters.
			throw new IllegalArgumentException("Invalid Phone Number");
		Number = number;
	}
	//returns the contact address.
	public String getAddress() {
		return Address;
	}
	//Sets or updates the contacts address.
	public void setAddress(String address) {
		if(address.length() > 30 || address == null)//Validates that address is not null and under 30 characters.
			throw new IllegalArgumentException("Invalid Address");
		Address = address;
	}
	
}
