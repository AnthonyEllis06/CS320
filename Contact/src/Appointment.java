/*
 * Author: 		Anthony Ellis
 * Date:		02/08/2023
 * Description:	Appointment object class
 * 
 */
import java.util.Date;
//Appointment Class
public class Appointment {
	
	//Appointment variable definition
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	//Appointment constructor uses setters to deal with invalid inputs
	public Appointment(String id, Date date, String description) {
		setID(id);
		setDate(date);
		setDescription(description);
	}
	
	//Appointment ID Setter
	//Is private to keep immutable
	private void setID(String id) {
		if(id == null || id.length() > 10)//verifies string correct length and not null
			throw new IllegalArgumentException("Invalid ID");//Throws exception for invalid id.
		this.appointmentID = id;
	}
	
	//ID getter
	public String getID() {
		return this.appointmentID;
	}
	
	//Date Setter
	//Takes a Date object
	public void setDate(Date date) {
		Date today = new Date();
		if(date.before(today))
			throw new IllegalArgumentException("Invalid Date");
		this.appointmentDate = date;
	}
	
	//Date Getter
	//returns a date object
	public Date getDate() {
		return this.appointmentDate;
	}
	
	//Description setter
	//Takes a string no longer than 50 chars.
	public void setDescription(String description) {
		if(description == null || description.length() >50)
			throw new IllegalArgumentException("Invalid Description");
		this.appointmentDescription = description;
	}
	
	//Description getter
	//returns a string object
	public String getDescription() {
		return this.appointmentDescription;
	}
}
