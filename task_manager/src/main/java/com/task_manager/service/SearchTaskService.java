package com.task_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task_manager.converter.TaskRowConverter;
import com.task_manager.dto.TaskListResultDto;
import com.task_manager.entity.TaskEntity;
import com.task_manager.form.SearchTaskNameForm;
import com.task_manager.mapper.TaskMapper;
import com.task_manager.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchTaskService {
	
	private final TaskMapper taskMapper;
	
	private final UserMapper userMapper;
	
	private final TaskRowConverter taskRowConverter;
	
//	private final SearchTaskNameForm searchTaskNameForm;
	
	/** 
	 * タスク名の完全一致・部分一致検索を行い該当するタスクを取得
	 * 
	 * @param searchTaskNameForm 
	 * @return 検索条件に一致した{@link TaskListResultDto}クラスのタスクリスト。検索条件に一致するタスクが一つもない場合は、全件表示
	 * 
	 * */
//	public TaskListResultDto execute(SearchTaskNameForm searchTaskNameForm) {
//		List<TaskEntity> taskEntities = this.taskMapper.findByTaskName(false, searchTaskNameForm.getSearchTaskName());
//		if(taskEntities == null || taskEntities.isEmpty()) {
//			
//		}
//		
//	}

}
