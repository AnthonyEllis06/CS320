/*
 * Author: 		Anthony Ellis
 * Date:		02/08/2023
 * Description:	Appointment Service object class
 * 
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class AppointmentService {
	
	//Map to contain and manage appointments.
	private Map<String , Appointment> appointments;
	
	//Class constructor primarily to initialize map.
	public AppointmentService() {
		this.appointments = new HashMap<String, Appointment>();
	}
	
	//Add appointment method
	//Arguments are appointment variables
	public void AddAppointment(String id, Date date, String description) {
		appointments.putIfAbsent(id, new Appointment(id, date, description));
	}
	
	//Delete appointment Method
	//argument is String id
	public void DeleteAppointment(String id) {
		appointments.remove(id);
	}
	
	//Get appointment object
	//Argument is string id.
	public Appointment GetAppointment(String id) {
		if(appointments.get(id)== null) {//if id is null then it does not exist
			throw new IllegalArgumentException("Appointment with ID does not exist.");
		}
		return appointments.get(id);
	}
}
