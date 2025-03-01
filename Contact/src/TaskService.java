import java.util.HashMap;
import java.util.Map;

/*
 * Author:		Anthony Ellis
 * Date:		01/31/2025
 * Description:	Task Service Object Class
 *  used to manage a container of task objects.
 *
 */
public class TaskService {
	
	//Map container for all the tasks.
	private Map<String, Task> Tasks;
	
	
	//Task Service Constructor, creates the map.
	public TaskService() {
		Tasks = new HashMap<String, Task>();
	}
	
	//Adds a single task to the Tasks Map
	//null inputs are not valid
	//Task ID maximum length 10 characters.
	//Task Name maximum length 10 characters.
	//Task Description maximum length of 50 characters.
	public void AddTask(String id, String name, String description) {
		Tasks.putIfAbsent(id, new Task(id,name,description));
	}
	
	//Updates a Task using its TaskID, Null inputs are skipped.
	public void UpdateTasks(String id, String name, String description) {
		if(name != null)
			Tasks.get(id).setTaskName(name);
		if(description != null)
			Tasks.get(id).setTaskDescription(description);
	}
	
	//Returns Task using TaskID
	public Task getTask(String id) {
		if(Tasks.get(id)==null)
			throw new IllegalArgumentException("Task with ID does not exist.");
			
		return Tasks.get(id);
	}
	
	//Removes Task from task map
	public void DeleteTask(String id) {
		Tasks.remove(id);
	}
}
