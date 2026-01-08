package com.task_manager.service;

import org.springframework.stereotype.Service;

import com.task_manager.converter.command.CreateTaskCommandConverter;
import com.task_manager.dto.TaskCreateResultDto;
import com.task_manager.entity.TaskEntity;
import com.task_manager.form.CreateTaskForm;
import com.task_manager.mapper.TaskMapper;
import com.task_manager.mapper.UserMapper;
import com.task_manager.util.TaskErrorType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateTaskService {

    private final ViewAllTasksService viewAllTasksService;
	
	private final TaskMapper taskMapper;
	
	private final UserMapper userMapper;
	
	private final CreateTaskCommandConverter createTaskCommandConverter;

    
	
	public TaskCreateResultDto execute(CreateTaskForm createTaskForm) {
		TaskEntity taskEntity = createTaskCommandConverter.convert(createTaskForm);
		
		if (taskEntity == null || taskEntity.getTaskName().isEmpty()
				|| taskEntity.getDueDate() == null
				|| taskEntity.getPriority() == null
				|| taskEntity.getStatus() == null
				|| taskEntity.getMngUser() == null) {
			return TaskCreateResultDto.failed(TaskErrorType.TASK_INFO_INCOMPLETE);
		} else {
			return TaskCreateResultDto.succeed();
		}
	} 

}
