package com.task_manager.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.task_manager.converter.TaskRowConverter;
import com.task_manager.dto.TaskListResultDto;
import com.task_manager.entity.TaskEntity;
import com.task_manager.entity.UserEntity;
import com.task_manager.form.SearchTaskNameForm;
import com.task_manager.form.TaskRowForm;
import com.task_manager.mapper.TaskMapper;
import com.task_manager.mapper.UserMapper;
import com.task_manager.util.TaskErrorType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchTaskService {
	
	private final TaskMapper taskMapper;
	
	private final UserMapper userMapper;
	
	private final TaskRowConverter taskRowConverter;
	
	private final ViewAllTasksService viewAllTasksService;
	
	/** 
	 * タスク名の完全一致・部分一致検索を行い該当するタスクを取得
	 * 
	 * @param searchTaskNameForm 
	 * @return 検索条件に一致するタスクが一つもない場合は全件表示、検索条件に一致するタスクがある場合は{@link TaskListResultDto}クラスのタスクリスト。
	 * 
	 * */
	public TaskListResultDto execute(SearchTaskNameForm searchTaskNameForm) {
		//1.検索条件なしの場合の全件表示処理
		if (searchTaskNameForm.getSearchTaskName() == null || searchTaskNameForm.getSearchTaskName().isBlank()) {
			return viewAllTasksService.execute();
		}
		
		//2.検索条件ありの場合の表示処理
		List<TaskEntity> taskEntities = this.taskMapper.findByTaskName(false, searchTaskNameForm.getSearchTaskName());
		
		if (taskEntities == null || taskEntities.isEmpty()) {
			return TaskListResultDto.failedTaskListForm(TaskErrorType.TASK_NOT_FOUND);
		} else {
			//1.全ユーザーを一度だけ取得して、IDをキー、ユーザー名をValueにしたMapを作成
			Map<Integer, String> userMap = userMapper.findAllUsers().stream()
					.collect(Collectors.toMap(
							UserEntity::getId,
							UserEntity::getUserName
							));
			//2.TaskEntityからTaskRowFormへの詰め変え
			List<TaskRowForm> taskForms = taskEntities.stream()
					.map(entity -> taskRowConverter.convert(entity, userMap))
					.toList();
			return TaskListResultDto.succeedTaskListForm(taskForms);
		}
		
		
		
	}

}
