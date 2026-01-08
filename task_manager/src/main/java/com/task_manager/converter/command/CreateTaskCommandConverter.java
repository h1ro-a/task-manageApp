package com.task_manager.converter.command;

import org.springframework.stereotype.Component;

import com.task_manager.entity.TaskEntity;
import com.task_manager.form.CreateTaskForm;

@Component
public class CreateTaskCommandConverter {
	
	public TaskEntity convert(CreateTaskForm createTaskForm) {
		TaskEntity taskEntity = new TaskEntity();
		return taskEntity;
	}

}
