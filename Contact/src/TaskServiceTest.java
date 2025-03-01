import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Author:		Anthony Ellis
 * Date:		01/31/2025
 * Description:	Task Object Class
 * 
 *
 */
class TaskServiceTest {

	//Test that a task was created and added to the task service map.
	@Test
	void testTaskServiceClass() {
		TaskService ts = new TaskService();
		ts.AddTask("TaskID1234", "Task Names Under 20.", "Task Description must be less than around 51 char.");
		assertTrue(ts.getTask("TaskID1234").getTaskDescription().equals("Task Description must be less than around 51 char."));
	}
	
	//Test update method of Task service.
	@Test
	void TestTaskServiceUpdateTask() {
		TaskService ts = new TaskService();
		
		
		ts.AddTask("TaskID1234", "Task Names Under 20.", "Task Description must be less than around 51 char.");
		ts.UpdateTasks("TaskID1234", "Task Names new 2012.", "Somethign different was made here,new description.");//update both mutable variables
		assertAll(
				()->assertTrue(ts.getTask("TaskID1234").getTaskName().equals("Task Names new 2012.")),
				()->assertTrue(ts.getTask("TaskID1234").getTaskDescription().equals("Somethign different was made here,new description.")));
		//assertTrue(ts.getTask("TaskID1234").getTaskName().equals("Task Names new 2012."));//verify both variables were updated successfully, individually 
		//assertTrue(ts.getTask("TaskID1234").getTaskDescription().equals("Somethign different was made here,new description."));
	}
	
	//Test task service delete method
	@Test
	void testTaskServiceDelete() {
		TaskService ts = new TaskService();
		String id = "TaskID1234";
		ts.AddTask(id, "Task Names Under 20.", "Task Description must be less than around 51 char.");//add task
		assertAll(
		()-> assertTrue(ts.getTask(id).getTaskName().equals("Task Names Under 20.")),
		()-> ts.DeleteTask(id),
		()-> Assertions.assertThrows(IllegalArgumentException.class, ()->{ts.getTask(id);})
		);
		
		//assertTrue(ts.getTask(id).getTaskName().equals("Task Names Under 20."));//verify task is there
		//ts.DeleteTask(id);//delete task
		//Assertions.assertThrows(IllegalArgumentException.class, ()->{ts.getTask(id);});//verify task is gone.
	}

}
