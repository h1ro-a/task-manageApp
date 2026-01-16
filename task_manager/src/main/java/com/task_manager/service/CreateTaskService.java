package com.task_manager.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task_manager.converter.command.CreateTaskCommandConverter;
import com.task_manager.dto.TaskCreateResultDto;
import com.task_manager.entity.TaskEntity;
import com.task_manager.form.CreateTaskForm;
import com.task_manager.mapper.TaskMapper;
import com.task_manager.util.TaskErrorType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateTaskService {
	
	private final TaskMapper taskMapper;
	
	private final CreateTaskCommandConverter createTaskCommandConverter;
	
	/** 
	 * 画面から入力された情報を元にタスクを登録する
	 * <p>
	 * 入力値の必須チェックおよび形式チェックは、{@link CreateTaskForm} に付与された
	 * Bean Validation により事前に検証されています
	 * </p>
	 * 
	 * @param createTaskForm
	 * @return タスクの登録の結果を表す{@link TaskCreateResultDto}
	 * 
	 * */
	@Transactional
	public TaskCreateResultDto execute(CreateTaskForm createTaskForm) {
		try {
			TaskEntity taskEntity = createTaskCommandConverter.convert(createTaskForm);
			taskMapper.createTask(taskEntity);
			return TaskCreateResultDto.succeed();
		} catch (DataAccessException ex) {
			return TaskCreateResultDto.failed(TaskErrorType.SYSTEM_ERROR);
		}
	} 

}
