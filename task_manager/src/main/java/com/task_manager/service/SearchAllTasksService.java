package com.task_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task_manager.dto.TaskListResultDto;
import com.task_manager.entity.Task;
import com.task_manager.mapper.TaskMapper;
import com.task_manager.util.TaskErrorType;

@Service
public class SearchAllTasksService {
	
	@Autowired
	private TaskMapper mapper;
	
	/** 
	 * 削除フラグのないタスクリストの取得
	 * 
	 * @return タスクリストの生成が成功した場合は{@link TaskListResultDto}クラスのタスクリスト、失敗した場合はエラーメッセージとエラータイプを返す。
	 * */
	public TaskListResultDto execute() {
		List<Task> tasks = this.mapper.findByDelFlgTasks(false);
		if (tasks == null || tasks.isEmpty()) {
			return TaskListResultDto.failedTaskListForm("表示するタスクがありません", TaskErrorType.TASK_NO_DATA);
		} else {
			return TaskListResultDto.succeedTaskListForm(tasks);
		}
	}

}
