/*
 * Author: 		Anthony Ellis
 * Date:		02/08/2023
 * Description:	Appointment Service Test class
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	//predefined variables for testing
	String fiftyCharString = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx";
	String tenCharString = "abcdefghij";
	@SuppressWarnings("deprecation")
	Date dateFuture = new Date(125, 11, 06);
	@SuppressWarnings("deprecation")
	Date dateOld = new Date(125, 1, 6);
	
	//Test appointment service add method to verify an item was inserted and retrieved correctly
	@Test
	void testAppointmentService() {
		AppointmentService as = new AppointmentService();
		as.AddAppointment(tenCharString, dateFuture, fiftyCharString);//add appointment
		assertTrue(as.GetAppointment(tenCharString).getDescription().equals(fiftyCharString));//verify information
	}
	
	//Test delete method
	@Test
	void testAppointmentServiceDelete() {
		AppointmentService as = new AppointmentService();
		as.AddAppointment(tenCharString, dateFuture, fiftyCharString);//add
		//Verify it is there, delete then verify it is gone
		assertAll(
				()->assertTrue(as.GetAppointment(tenCharString).getDescription().equals(fiftyCharString)),
				()->as.DeleteAppointment(tenCharString),
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{as.GetAppointment(tenCharString);})
		);
	}

}
