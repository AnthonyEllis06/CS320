import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/*
 * Author:		Anthony Ellis
 * Date:		01/31/2025
 * Description:	Tester class for the task object class
 * 
 *
 */
class TaskTest {

	//Test to verify that a task was created and all of its variables were set correctly.
	@Test
	void testTaskClass() {
		Task task = new Task("TaskID1234","Task Names Under 20.","Task Description must be less than around 51 char.");
		assertAll(
				()->assertTrue(task.getTaskID().equals("TaskID1234")),
				()->assertTrue(task.getTaskName().equals("Task Names Under 20.")),
				()->assertTrue(task.getTaskDescription().equals("Task Description must be less than around 51 char."))
		);
	}
	
	//Test to verify that illegal argument exceptions are thrown when the Task ID is too long or null.
	@Test
	void testTaskIDTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Task("TaskID12345","Task Names Under 20.","Task Description must be less than around 51 char.");}),
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Task(null,"Task Names Under 20.","Task Description must be less than around 51 char.");})
		);
	}
	
	//Test to verify that illegal argument exceptions are thrown when a task is created with task name is too long or null.
	@Test
	void TestTaskNameTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Task("TaskID1234","Task Names Under 20.+","Task Description must be less than around 51 char.");}),
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Task("TaskID1234",null,"Task Description must be less than around 51 char.");})
		);
	}
	
	//Test to verify that an illegal argument exception is thrown if the description of the class is null or too long.
	@Test
	void TastTaskDescriptionTooLong() {
		assertAll(
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Task("TaskID1234","Task Names Under 20.","Task Description must be less than around 51 chars.");}),
				()->Assertions.assertThrows(IllegalArgumentException.class, ()->{new Task("TaskID1234","Task Names Under 20.",null);})
		);
	}

}
