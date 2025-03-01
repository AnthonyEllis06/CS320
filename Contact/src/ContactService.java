import java.util.Map;
import java.util.HashMap;

/*
 * Author: Anthony Ellis
 * Date: 01/24/2025
 * Description: The Contact Service Class works as container interface to hold the contact objects and easily access the 
 * 					correct Contact object using a non-repeatable and non-null Contact ID. The Contact Service class can
 * 					also update and delete contacts.
 */

public class ContactService {
	
	private Map<String , Contact> Contacts;
	//base constructor to create the HashMap of all the contacts to be held in memory.
	
	ContactService(){
		Contacts = new HashMap<String, Contact>();
	}
	
	//Returns contact object using Contact ID.
	public Contact GetContact(String id) {
		if(Contacts.get(id)==null)
			throw new IllegalArgumentException("Contact With ID does not Exist");
		return Contacts.get(id);
	}	
	
	//Adds a single contact to the map.
	//null inputs are not valid.
	//Contact ID, First Name, and Last Name, must be a maximum length of 10 char.
	//Contact Phone Number must be exactly 10 char long.
	//Contact Address can not be longer than 30 characters.
	public void AddContact(String id, String firstName,String lastName, String Number, String Address) {
		Contact temp = new Contact(id, firstName, lastName, Number, Address);
		Contacts.putIfAbsent(id, temp);//Adds if it is not a repeat.
	}
	
	//Removes Contact from map. Uses Contact ID.
	public void DeleteContact(String id) {
		Contacts.remove(id);
	}
	
	//updates contact using contact ID and setting the new inputs for the contact info.String ID can not be null,
	//however, the variables that are not being changed can be null.
	public void UpdateContact(String id,String fName, String lName, String num, String addr){
		//If statement to only update the neccessary variabels. 
		if(fName != null) {
			Contacts.get(id).setFirstName(fName);
		}
		if(lName != null) {
			Contacts.get(id).setLastName(lName);
		}
		if(num != null) {
			Contacts.get(id).setNumber(num);
		}
		if(addr != null) {
			Contacts.get(id).setAddress(addr);
		}
	}
}
