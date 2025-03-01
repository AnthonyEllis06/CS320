import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Author: 		Anthony Ellis
 * Date:		02/08/2023
 * Description:	Appointment Test class
 * 
 */
class AppointmentTest {
	//predefined test variables used for boundary testing.
	String fiftyCharString = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx";
	String tenCharString = "abcdefghij";
	@SuppressWarnings("deprecation")
	Date dateFuture = new Date(125, 11, 06);
	@SuppressWarnings("deprecation")
	Date dateOld = new Date(125, 1, 6);
	
	//test to see if appointment is made correctly
	@Test
	void testAppointmentClass() {
		Appointment appointment = new Appointment(tenCharString, dateFuture, fiftyCharString );
		assertAll(
				()->assertTrue(appointment.getID().equals(tenCharString)),
				()->assertTrue(appointment.getDate().equals(dateFuture)),
				()->assertTrue(appointment.getDescription().equals(fiftyCharString))
		);
	}
	
	//verifies that exceptions are thrown for null ID or ID too long
	@Test
	void testAppointmentIDNullOrTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Appointment(tenCharString + "k", dateFuture, fiftyCharString);}),
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Appointment(null, dateFuture, fiftyCharString);})
		);
	}
	
	//Test if ID made for a prior date that a exception is thrown
	@Test
	void testAppointmentDateOld() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{new Appointment(tenCharString , dateOld, fiftyCharString);});
		
	}
	
	//Test for null description and description too long.
	@Test
	void testAppointmentDescriptionNullOrTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Appointment(tenCharString, dateFuture, fiftyCharString + "y");}),
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Appointment(tenCharString, dateFuture, null);})
		);
	}

}
