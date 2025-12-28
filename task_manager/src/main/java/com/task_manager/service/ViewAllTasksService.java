package com.task_manager.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.task_manager.converter.TaskRowConverter;
import com.task_manager.dto.TaskListResultDto;
import com.task_manager.entity.TaskEntity;
import com.task_manager.entity.UserEntity;
import com.task_manager.form.TaskRowForm;
import com.task_manager.mapper.TaskMapper;
import com.task_manager.mapper.UserMapper;
import com.task_manager.util.TaskErrorType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ViewAllTasksService {
	
	private final TaskMapper taskMapper;
	
	private final UserMapper userMapper;

	private final TaskRowConverter taskRowConverter;
	/** 
	 * 削除していないタスクを全件取得
	 * 
	 * @return タスクリストの生成が成功した場合は{@link TaskListResultDto}クラスのタスクリスト、失敗した場合はエラーメッセージとエラータイプを返す。
	 * */
	public TaskListResultDto execute() {
		List<TaskEntity> taskEntities = this.taskMapper.findByDelFlgTasks(false);
		if (taskEntities == null || taskEntities.isEmpty()) {
			return TaskListResultDto.failedTaskListForm("表示するタスクがありません", TaskErrorType.TASK_NO_DATA);
		} else {
			//1.全ユーザーを一度だけ取得して、IDをキーにしたMapを作成
			Map<Integer, String> userMap = userMapper.findAllUsers().stream()
					.collect(Collectors.toMap(
							UserEntity::getId,
							UserEntity::getUserName
							));
			
			//2.TaskEntityからTaskRowFormへの詰め替え
			List<TaskRowForm> taskForms = taskEntities.stream()
					.map(entity -> taskRowConverter.convert(entity, userMap))
					.toList();
			return TaskListResultDto.succeedTaskListForm(taskForms);
		}
		
	}
	
}
