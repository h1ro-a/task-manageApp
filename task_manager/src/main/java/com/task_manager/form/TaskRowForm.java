package com.task_manager.form;

import lombok.Data;

@Data
public class TaskRowForm {
	private Integer id;
	
	private String taskName;
	
	private String taskDscript;
	
	private String dueDate;
	
	private String priorityLabel;
	
	private String statusLabel;
	
	private String mngUser;
	
	private String userName;
	
	

}
