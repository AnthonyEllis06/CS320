import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Author: 		Anthony Ellis
 * Date: 		1/24/2025
 * Description: Tester class for the contact object class.
 */

class ContactTest {
	
	//Test to verify that a contact was created and all the variables were set correctly as entered.
	@Test
	void testContactClass() {

		Contact contact = new Contact("testID1234","Anthony", "Ellis", "4238396413","102 hawkins road");//Create Contact
		//verify object variables set correctly
		assertAll(
		()->assertTrue(contact.getContactID().equals("testID1234")),
		()->assertTrue(contact.getFirstName().equals("Anthony")),
		()->assertTrue(contact.getLastName().equals("Ellis")),
		()->assertTrue(contact.getNumber().equals("4238396413")),
		()->assertTrue(contact.getAddress().equals("102 hawkins road"))
		);
	}
	
	//Test to verify that Illegal argument exceptions are thrown when Contact id is too long or too short.
	@Test
	void testContactIDTooLong() {
		assertAll(
		()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID12345","Anthony", "Ellis", "4238396413","102 hawkins road");}),
		()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact(null,"Anthony", "Ellis", "4238396413","102 hawkins road");})
		);
	}
	
	//Test to verify that an exception is throw if First name is null or too long.
	@Test
	void testContactFirstNameTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID1234","Anthony1234", "Ellis", "4238396413","102 hawkins road");}),
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID1234",null, "Ellis", "4238396413","102 hawkins road");})
		);
	}
	
	//Test to verify that contact name is not too long or null.
	@Test
	void testContactLasNameTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID1234","Anthony", "Ellis123456", "4238396413","102 hawkins road");}),
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID1234","Anthony", null, "4238396413","102 hawkins road");})
		);
	}
	
	//Test to verify that contact phone number is not too long or null.
	@Test
	void testContactPhoneNumberTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID1234","Anthony", "Ellis", "42383964130","102 hawkins road");}),
				()->Assertions.assertThrows(NullPointerException.class,()->{ new Contact("testID1234","Anthony", "Ellis", null,"102 hawkins road");})
		);
	}
	
	//Test to verify that contact phone number is not too short.
	//Both length test are boundary test.
	@Test
	void testContactPhoneNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID1234","Anthony", "Ellis", "423839641","102 hawkins road");});
	}
	
	//Verifies that the contact address is not too long or null.
	@Test
	void testContactAddressTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID12345","Anthony", "Ellis", "4238396413","102 hawkins road123456789123456");}),
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{ new Contact("testID12345","Anthony", "Ellis", "4238396413",null);})
		);
	}
}
