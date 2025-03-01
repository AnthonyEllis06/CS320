import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Author: Anthony Ellis
 * Date: 1/24/2025
 * Description:	Tester Class for Contact Service
 */

class ContactServiceTest {

	//Test that a contact was created and added to the Contact Service Map
	@Test
	void testContactServiceClass() {
		ContactService cs = new ContactService();//create contact service class object.
		cs.AddContact("TestID1234", "Anthony", "Ellis", "4238396413", "122 Burlington CT");//add contact
		assertTrue(cs.GetContact("TestID1234").getAddress().equals("122 Burlington CT"));//verify contact is retrievable and the same.
	}
	
	//Test the update method of the Contact Service
	@Test
	void TestContactServiceUpdateContact() {
		ContactService cs = new ContactService();
		cs.AddContact("TestID1234", "Anthony", "Ellis", "4238396413", "122 Burlington CT");//add contact.
		cs.UpdateContact("TestID1234", "Anthonyie", "Ellisaa", "4238396414", "123 Burlington CT");//update contact
		//verify updated details are represented.
		assertAll(
				()->assertTrue(cs.GetContact("TestID1234").getFirstName().equals("Anthonyie")),
				()->assertTrue(cs.GetContact("TestID1234").getLastName().equals("Ellisaa")),
				()->assertTrue(cs.GetContact("TestID1234").getNumber().equals("4238396414")),
				()->assertTrue(cs.GetContact("TestID1234").getAddress().equals("123 Burlington CT"))
		);
	}
	
	//Test to verify that Contact Service deletes the contact.
	@Test
	void TestContactServiceDeleteContact() {
		ContactService cs = new ContactService();
		String id = "TestID1234";
		cs.AddContact(id, "Anthony", "Ellis", "4238396413", "122 Burlington CT");//add contact
		//Verify contact is there then delete it and then verify that the contact is not there
		assertAll(
				()->assertTrue(cs.GetContact(id).getNumber().equals("4238396413")),
				()->cs.DeleteContact(id),
				()->Assertions.assertThrows(IllegalArgumentException.class,()->{cs.GetContact(id);})
		);
	}

}
