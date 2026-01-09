package com.task_manager.converter.command;

import org.springframework.stereotype.Component;

import com.task_manager.entity.TaskEntity;
import com.task_manager.form.CreateTaskForm;

@Component
public class CreateTaskCommandConverter {
	
	/** 
	 * {@link CreateTaskForm}型のオブジェクトを{@link TaskEntity}に変換する
	 * 
	 * */
	public TaskEntity convert(CreateTaskForm createTaskForm) {
		TaskEntity taskEntity = new TaskEntity();
		

        taskEntity.setTaskName(createTaskForm.getTaskName());
        taskEntity.setTaskDscript(createTaskForm.getTaskDscript());
        taskEntity.setDueDate(parseDueDate(createTaskForm.getDueDate()));
        taskEntity.setPriority(createTaskForm.getPriority());
        taskEntity.setStatus(createTaskForm.getStatus());
        taskEntity.setMngUser(createTaskForm.getMngUser());
		return taskEntity;
	}

}
