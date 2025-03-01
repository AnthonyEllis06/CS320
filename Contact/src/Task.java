/*
 * Author:		Anthony Ellis
 * Date:		01/31/2025
 * Description:	Task Object Class
 * 
 *
 */


public class Task {
	
	//Task key variables
	//ID can not be updated and must be set during declaration;
	private String taskID;
	private String taskName;
	private String taskDescription;
	
	//Constructor
	//id must be a unique non-null string, with a maximum of 10 chars.
	//name must be a non-null string, with a maximum of 20 chars.
	//description must be a non-null string, with a maximum of 50 chars
	public Task(String id, String name, String description) {
		setTaskID(id);
		setTaskName(name);
		setTaskDescription(description);
	}
	
	//Task ID setter
	//ID must be a string object less than 10 char in length.
	private void setTaskID(String id) {
		if(id == null || id.length() > 10)//verifies string correct length and not null
			throw new IllegalArgumentException("Invalid ID");//Throws exception for invalid id.
		this.taskID = id;
	}
	
	//Task ID getter
	//returns task ID string object.
	public String getTaskID() {
		return this.taskID;
	}
	
	//Task name setter
	//String argument must be less than 20 char and not null
	public void setTaskName(String name) {
		if(name == null || name.length() > 20)
			throw new IllegalArgumentException("Invalid Name");
		this.taskName = name;
	}
	
	//Task Name getter
	//returns task name string object
	public String getTaskName() {
		return this.taskName;
	}
	
	//Task Description setter.
	//Sets the given string object as the Description
	//takes a non-null string object with length less than 51.
	public void setTaskDescription(String description) {
		if(description == null || description.length() >50)
			throw new IllegalArgumentException("Invalid Description");
		this.taskDescription = description;
	}
	
	//Task Description Getter
	//returns String object.
	public String getTaskDescription() {
		return this.taskDescription;
	}
}

